package com.xiahe.service;

import com.xiahe.dao.OrderrDao;
import com.xiahe.entity.Orderr;
import com.xiahe.entity.Other;
import com.xiahe.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

//订单类服务
@Service
public class OrderrServiceImp extends ServiceImp<Orderr> implements OrderrService {

    public OrderrServiceImp() {
        super(OrderrDao.class);
    }


    //生成订单
    @Override
    public String generate(Model model, HttpSession session, Orderr orderr) {
        //判断是自定义还是选择套餐
        User user = (User) session.getAttribute("user");
        OtherService otherService = new OtherServiceImp();
        List<Other> selects = otherService.selects("where username = " + user.getUsername());
        Other other = selects.size() > 0 ? selects.get(0) : null;
        if (other == null) return "/front/hit.jsp";//没有查到余额
        try {
            if (orderr.getUsername() != null) {//自定义数量
                orderr.setCount(Integer.valueOf(orderr.getUsername()));
                orderr.setUsername(user.getUsername());
                orderr.setStatus(1);
                orderr.setAmount(Double.valueOf(orderr.getCount()) / 100);
                model.addAttribute("orderr", orderr);
                return other.getBalance() >= orderr.getAmount() ? "/front/oinvoice.jsp" : "/front/hit.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer integer = Integer.valueOf(orderr.getOther());
        orderr.setCount(integer);
        orderr.setAmount(Double.valueOf(orderr.getCount()) / 100);
        orderr.setUsername(user.getUsername());
        orderr.setStatus(1);
        model.addAttribute("orderr", orderr);
        //计算余额是否足够
        return other.getBalance() >= orderr.getAmount() ? "/front/oinvoice.jsp" : "/front/hit.jsp";
    }


    //写入订单
    @Override
    public boolean orderr(Orderr orderr) {
        OtherService otherService = new OtherServiceImp();
        List<Other> selects = otherService.selects("where username = " + orderr.getUsername());
        Other other = selects.size() > 0 ? selects.get(0) : null;
        if (other != null) {
            other.setCount(other.getCount() + orderr.getCount());//把购买的IP写入到Other表
            other.setBalance(other.getBalance() - orderr.getAmount());//把扣去的费用写入到Other表
            if (other.getBalance() > 0) {
                insert(orderr); //把订单写入到订单表
                otherService.update(other);
            }
        }
        return true;
    }


}
