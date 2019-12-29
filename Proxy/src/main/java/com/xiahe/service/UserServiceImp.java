package com.xiahe.service;

import com.xiahe.dao.OtherDao;
import com.xiahe.dao.UserDao;
import com.xiahe.entity.Other;
import com.xiahe.entity.User;
import com.xiahe.tool.Tools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class UserServiceImp extends ServiceImp<User> implements UserService {

    public UserServiceImp() {
        super(UserDao.class);
    }

    @Override
    public Map<String, Object> isOccupy(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        User select = select(user);
        map.put("result", select != null);// true说明该手机号已经被注册
        map.put("message", select != null ? "该手机号已注册" : "正常");
        return map;
    }

    @Override
    public Map<String, Object> phoneCode(User user, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", Tools.phoneCode(user, session));// 手机号发送验证码
        map.put("message", (boolean) map.get("result") ? "成功" : "失败");
        return map;
    }

    @Override
    public void systemCode(HttpServletRequest request, HttpServletResponse response) {
        Tools.systemCode(request, response);// 系统验证码
    }

    @Override
    public String signup(User user, HttpSession session) {
        //用户为空
        if (user == null || session.getAttribute("systemCode") == null || session.getAttribute("phoneCode") == null) {
            return "注册失败";
        }
        //系统验证码不符合
        if (!session.getAttribute("systemCode").toString().equalsIgnoreCase(user.getOther())) {
            return "系统验证码错误";
        }
        //手机验证码不符合
        if (!session.getAttribute("phoneCode").equals(user.getPhoneCode())) {
            return "手机验证码错误";
        }
        //验证通过则登陆成功
        session.setAttribute("user", user);
        //该用户是否已经注册
        User select = select(user);
        if (select != null) {
            select.setPassword(user.getPassword());
            update(select);
            return "success";
        }
        //注册用户
        user.setPermission(1);
        insert(user);
        Service<Other> otherService = new ServiceImp<>(OtherDao.class);
        Other other = new Other();
        other.setUsername(user.getUsername());
        other.setCount(0);
        other.setBalance(0);
        otherService.insert(other);
        return "success";
    }

    @Override
    public String signin(User user, HttpSession session) {
        //未生成验证码
        if (session.getAttribute("systemCode") == null) {
            return "系统验证码错误";
        }
        // 验证码错误
        if (!session.getAttribute("systemCode").toString().equalsIgnoreCase((user.getOther()))) {
            return "系统验证码错误";
        }

        User select = select(user);// 查询出当前用户
        // 当前用户不存在
        if (select == null) {
            return "手机号不存在";
        }

        // 密码错误
        if (!select.getPassword().equals(user.getPassword())) {
            return "密码错误";
        }

        //权限检查
        if (select.getPermission() <= 0) {
            return "账号被锁定";
        }

        // 登陆成功
        session.setAttribute("key", select.getPermission() == 2 ? "admin" : "user");
        session.setAttribute((String) session.getAttribute("key"), select);
        return "success";
    }

    @Override
    public String signout(HttpSession session, User user) {
        session.setAttribute(user.getPermission() == 2 ? "admin" : "user", null);
        return "redirect:/front/signin.jsp";
    }

    //----------------后台业务-------------

    //根据ID删除用户
    @Override
    public boolean delete(User user) {
        if (user.getUsername() != null) {//用户名不为空根据用户名删
            return super.delete(user);
        }
        //没有用户名根据ID删
        List<User> selects = selects("where id = " + user.getId());
        if (selects.size() > 0) {
            return super.delete(selects.get(0));
        }
        return true;
    }

    //批量冻结
    @Override
    public boolean freezes(List<Integer> ids) {
        try {
            for (Integer id : ids) {
                List<User> selects = selects("where id = " + id);
                selects.get(0).setPermission(-selects.get(0).getPermission());
                update(selects.get(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
