package com.xiahe.controller;

import com.xiahe.entity.Page;
import com.xiahe.entity.Recharge;
import com.xiahe.entity.User;
import com.xiahe.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/recharge")
public class RechargeController {
    @Autowired
    private RechargeService service;

    //-------------------前台业务----------------
    //生成订单
    @RequestMapping("/generate")
    public String generate(Model model, HttpSession session, Recharge recharge) {
        return service.generate(model, session, recharge);
    }

    //发起支付宝申请
    @RequestMapping("/alipay")
    public void alipay(HttpSession session, HttpServletResponse response, Recharge recharge) {
        service.alipay(session, response, recharge);
    }

    //写入订单
    @RequestMapping("/recharge")
    public String recharge(Model model, HttpSession session) {
        Recharge recharge = (Recharge) session.getAttribute("recharge");
        model.addAttribute("message", service.recharge(recharge));
        return "redirect:/other/show.do?index=3";
    }


    //-------------------后台业务----------------

    //批量删除
    @RequestMapping("/deletes")
    public String deletes(Model model, Page page) {
        model.addAttribute("message", service.deletes(page.getIds(), new Recharge()));
        if (page.getOther() != null) {
            return "redirect:/recharge/selectps.do?index=" + page.getIndex() + "&condition=" + page.getCondition() + "&content=" + page.getContent() + "&size=1000&other=" + page.getOther();
        }
        return "redirect:/recharge/selectps.do?index=" + page.getIndex() + "&condition=" + page.getCondition() + "&content=" + page.getContent();
    }


    //分页查询
    @RequestMapping("/selectps")
    public String selectps(Model model, Page page, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (page.getOther() != null) {
            page.setCondition("username=" + user.getUsername() + " and " + page.getCondition());
        }
        model.addAttribute("recharges", service.selectps(model, page));
        return page.getOther() == null ? "/back/recharge.jsp" : page.getOther();
    }

}
