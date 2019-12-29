package com.xiahe.controller;

import com.xiahe.entity.Page;
import com.xiahe.entity.User;
import com.xiahe.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/other")
public class OtherController {
    @Autowired
    private OtherService service;

    //-------------------前台业务----------------
    //展示用户扩展信息
    @RequestMapping("/show")
    public String show(Model model, HttpSession session, Page page) {
        try {
            User user = (User) session.getAttribute("user");
            model.addAttribute("other", service.selects("where username = " + user.getUsername()).get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page.getIndex() == 1 ? "/front/orderr.jsp" : (page.getIndex() == 3 ? "redirect:/front/index.jsp" : "/front/recharge.jsp");
    }

    //-------------------后台业务----------------

}
