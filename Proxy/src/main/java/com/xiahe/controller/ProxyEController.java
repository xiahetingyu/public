package com.xiahe.controller;

import com.xiahe.entity.Page;
import com.xiahe.entity.ProxyE;
import com.xiahe.entity.User;
import com.xiahe.service.ProxyEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
@RequestMapping("/proxy")
public class ProxyEController {
    @Autowired
    private ProxyEService service;

    //-------------------前台业务----------------

    //-------------------后台业务----------------
    //批量删除
    @RequestMapping("/deletes")
    public String deletes(Model model, Page page) {
        model.addAttribute("message", service.deletes(page.getIds(), new ProxyE()));
        return "redirect:/proxy/selectps.do?index=" + page.getIndex() + "&condition=" + page.getCondition() + "&content=" + page.getContent();
    }

    //更新代理
    @RequestMapping("/update")
    public String update(Model model, ProxyE proxy, Page page) {
        model.addAttribute("message", service.update(proxy));
        return "redirect:/proxy/selectps.do?index=" + page.getIndex() + "&condition=" + page.getCondition() + "&content=" + page.getContent();
    }


    //分页查询代理
    @RequestMapping("/selectps")
    public String selectps(Model model, Page page) {
        model.addAttribute("proxyes", service.selectps(model, page));
        return "/back/proxy.jsp";
    }


    //---------------------核心业务------------------------
    //用户使用代理|使用手机号、密码和随机码的方式获取
    @RequestMapping("/take")
    public void take(User user, HttpServletResponse response) {
        try {
            PrintWriter writer = response.getWriter();
            writer.println(service.take(user, response));
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
