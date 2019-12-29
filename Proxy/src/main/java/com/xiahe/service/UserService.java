package com.xiahe.service;

import com.xiahe.entity.Page;
import com.xiahe.entity.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface UserService extends Service<User> {

    // 验证手机号是否已经注册
    Map<String, Object> isOccupy(User user);

    // 获取手机验证码
    Map<String, Object> phoneCode(User user, HttpSession session);

    // 系统验证码
    void systemCode(HttpServletRequest request, HttpServletResponse response);

    // 注册
    String signup(User user, HttpSession session);

    // 登陆
    String signin(User user, HttpSession session);

    // 注销
    String signout(HttpSession session, User user);

    //分页查询
    List<User> selectps(Model model, Page page);

    //冻结或解冻用户
    boolean freezes(List<Integer> ids);

}
