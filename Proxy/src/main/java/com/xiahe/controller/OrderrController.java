package com.xiahe.controller;

import com.xiahe.entity.Orderr;
import com.xiahe.entity.Page;
import com.xiahe.entity.User;
import com.xiahe.service.OrderrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/orderr")
public class OrderrController {
    @Autowired
    private OrderrService service;

    //-------------------前台业务----------------
    //生成订单
    @RequestMapping("/generate")
    public String generate(Model model, HttpSession session, Orderr orderr) {
        return service.generate(model, session, orderr);
    }

    //写入订单
    @RequestMapping("/orderr")
    public String recharge(Model model, Orderr orderr) {
        model.addAttribute("message", service.orderr(orderr));
        return "redirect:/other/show.do?index=1";
    }

    //-------------------后台业务----------------

    //批量删除
    @RequestMapping("/deletes")
    public String deletes(Model model, Page page) {
        model.addAttribute("message", service.deletes(page.getIds(), new Orderr()));
        if (page.getOther() != null) {
            return "redirect:/orderr/selectps.do?index=" + page.getIndex() + "&condition=" + page.getCondition() + "&content=" + page.getContent() + "&size=1000&other=" + page.getOther();
        }
        return "redirect:/orderr/selectps.do?index=" + page.getIndex() + "&condition=" + page.getCondition() + "&content=" + page.getContent();
    }


    //分页查询
    @RequestMapping("/selectps")
    public String selectps(Model model, Page page, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (page.getOther() != null) {
            page.setCondition("username=" + user.getUsername() + " and " + page.getCondition());
        }
        model.addAttribute("orderrs", service.selectps(model, page));
        return page.getOther() == null ? "/back/orderr.jsp" : page.getOther();
    }

}
