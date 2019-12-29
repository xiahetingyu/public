package com.xiahe.controller;

import com.xiahe.entity.Page;
import com.xiahe.entity.User;
import com.xiahe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    //-------------------前台业务----------------
    // 验证手机号是否已经注册
    @ResponseBody
    @RequestMapping("/isOccupy")
    public Map<String, Object> isOccupy(User user) {
        return service.isOccupy(user);
    }

    // 获取手机验证码
    @RequestMapping("/phoneCode")
    public Map<String, Object> phoneCode(User user, HttpSession session) {
        return service.phoneCode(user, session);
    }

    // 系统验证码
    @RequestMapping("/systemCode")
    public void systemCode(HttpServletRequest request, HttpServletResponse response) {
        service.systemCode(request, response);
    }

    // 注册
    @RequestMapping("/signup")
    public String signup(Model model, User user, HttpSession session) {
        String signup = service.signup(user, session);
        model.addAttribute("message", signup);
        return signup.equals("success") ? "/front/index.jsp?page=front/help.jsp" : "/front/signup.jsp";
    }

    // 登陆
    @RequestMapping("/signin")
    public String signin(Model model, User user, HttpSession session) {
        String signin = service.signin(user, session);
        model.addAttribute("message", signin);
        User select = (User) session.getAttribute((String) session.getAttribute("key"));
        return signin.equals("success") ? (select.getPermission() == 2 ? "/user/selectps.do" : "/front/index.jsp?page=front/help.jsp") : "/front/signin.jsp";
    }

    // 登出
    @RequestMapping("/signout")
    public String signout(HttpSession session, User user) {
        return service.signout(session, user);
    }

    //-------------------后台业务----------------
    //删除用户
    @RequestMapping("/delete")
    public String delete(Model model, User user, Page page) {
        model.addAttribute("message", service.delete(user));
        return "redirect:/user/selectps.do?index=" + page.getIndex() + "&condition=" + page.getCondition() + "&content=" + page.getContent();
    }

    //批量冻结
    @RequestMapping("/updates")
    public String updates(Model model, Page page) {
        model.addAttribute("message", service.freezes(page.getIds()));
        return "redirect:/user/selectps.do?index=" + page.getIndex() + "&condition=" + page.getCondition() + "&content=" + page.getContent();
    }

    //用户分页查询
    @RequestMapping("/selectps")
    public String selectps(Model model, Page page) {
        model.addAttribute("users", service.selectps(model, page));
        return "/back/user.jsp";
    }

}
