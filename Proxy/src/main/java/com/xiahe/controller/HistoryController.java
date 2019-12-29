package com.xiahe.controller;

import com.xiahe.entity.Page;
import com.xiahe.service.OrderrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    private OrderrService service;

    //-------------------前台业务----------------

    //-------------------后台业务----------------
    //查询所有用户
    @RequestMapping("/selects")
    public String selects(Model model) {
        model.addAttribute("users", service.selects());
        return "/back/user.jsp";
    }

    //用户分页查询
    @RequestMapping("/selectps")
    public String selectps(Model model, Page page) {
        model.addAttribute("users", service.selectps(model, page));
        return "/back/user.jsp";
    }

}
