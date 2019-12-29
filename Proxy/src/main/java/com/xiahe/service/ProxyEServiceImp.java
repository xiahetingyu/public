package com.xiahe.service;

import com.google.gson.Gson;
import com.xiahe.dao.ProxyEDao;
import com.xiahe.entity.History;
import com.xiahe.entity.Other;
import com.xiahe.entity.ProxyE;
import com.xiahe.entity.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//代理类服务
@Service
public class ProxyEServiceImp extends ServiceImp<ProxyE> implements ProxyEService {

    public ProxyEServiceImp() {
        super(ProxyEDao.class);
    }

    //更新IP可用性
    @Override
    public boolean update(ProxyE proxyE) {
        proxyE = select(proxyE);
        proxyE.setVer(-proxyE.getVer());
        super.update(proxyE);
        return true;
    }

    //核心业务|用户使用代理
    @Override
    public String take(User user, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        Gson gson = new Gson();
        //验证给定信息是否正确
        UserService userService = new UserServiceImp();
        User selectUser = userService.select(user);
        //如果查不到用户或者密码错误或者随机码错误|返回参数错误提示
        if (selectUser == null || !selectUser.getPassword().equals(user.getPassword()) || !selectUser.getPhoneCode().equals(user.getPhoneCode())) {
            map.put("code", 100);
            map.put("message", "Parameter error!");
            return gson.toJson(map);
        }

        //判断用户余量是否充足
        OtherService otherService = new OtherServiceImp();
        List<Other> others = otherService.selects("where username = " + selectUser.getUsername());
        if (others.size() <= 0 || others.get(0).getCount() <= 0) {
            map.put("code", 300);
            map.put("message", "Insufficient balance!");
            return gson.toJson(map);
        }

        //取出代理IP|查重
        List<ProxyE> selects = selects();
        Collections.shuffle(selects);//随机
        HistoryService historyService = new HistoryServiceImp();
        List<History> histories = historyService.selects("where username = " + selectUser.getUsername());
        for (ProxyE select : selects) {
            boolean flag = true;
            for (History history : histories) {
                if (select.getProxye().equals(history.getProxye())) {
                    flag = false;//查到重复数据
                    break;
                }
            }
            if (flag && select.getVer() > 0) {//找到了可用的代理
                //存入历史
                History history = new History();
                history.setUsername(selectUser.getUsername());
                history.setProxye(select.getProxye());
                historyService.insert(history);
                //余量减
                Other other = others.get(0);
                other.setCount(other.getCount() - 1);
                otherService.update(other);
                map.put("code", 200);
                map.put("proxy", select.getProxye());
                map.put("ip", select.getIp());
                map.put("port", select.getPort());
                map.put("message", "Success!");
                return gson.toJson(map);//返回IP
            }
        }
        map.put("code", 400);
        map.put("message", "Insufficient system margin!");
        return gson.toJson(map);
    }


}
