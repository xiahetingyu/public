package com.xiahe.service;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.xiahe.dao.UserDao;
import com.xiahe.entity.User;
import com.xiahe.tool.MD5Utils;
import com.xiahe.tool.SecurityCode;

public class UserServiceImp extends ServiceImp<User> implements UserService {

	public UserServiceImp() {
		super(UserDao.class);
	}

	// 验证码服务
	@Override
	public String ver() {
		try {
			String generateVerifyCode = SecurityCode.generateVerifyCode(4);
			System.out.println(generateVerifyCode);
			ServletActionContext.getRequest().getSession().setAttribute("ver", generateVerifyCode);
			BufferedImage image = SecurityCode.getImage(200, 80, generateVerifyCode);
			ImageIO.write(image, "png", ServletActionContext.getResponse().getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 验证邮箱
	@Override
	public String verEmail(User user) {
		User select = select(user);
		if (select == null || !select.getCode().equals(user.getCode())) {
			user.setOther("验证失败");
			return "verify_form.jsp";
		}
		select.setPermission(1);
		update(select);
		user.setNickname(select.getNickname());
		// 保存登陆信息到会话中
		ServletActionContext.getRequest().getSession().setAttribute("user", select);
		return "register_ok.jsp";
	}

	@Override
	public String signup(User user) {
		// 验证两次密码
		if (user.getPassword() == null || !user.getPassword().equals(user.getOther())) {
			user.setOther("两次密码不一致");
			return "signup";
		}

		// 注册验证验证码
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (!session.getAttribute("ver").toString().equalsIgnoreCase((user.getCode()))) {
			user.setOther("验证码错误");
			return "signup";
		}

		// 置空提示信息
		user.setOther(null);

		// 判断用户是否存在
		User select = select(user);
		if (select != null) {
			if (select.getPermission() == -3) {
				return "verify_form.jsp";
			}
			user.setOther("用户已注册");
			return "signup";
		}

		// 生成随机码
		user.setCode(MD5Utils.getSalt());

		// 生成密码
		user.setPassword(MD5Utils.getPassword(user.getPassword() + user.getCode()));

		// 设置权限并锁定
		user.setPermission(-3);

		// 写入数据库
		insert(user);

		return "verify_form.jsp";
	}

	// 用户和管理员公共的登陆服务
	@Override
	public String signin(User user) {
		User select = select(user);

		// 不存在该用户
		if (select == null) {
			user.setOther("该用户不存在");
			return Math.abs(user.getPermission()) == 1 ? "user" : "admin";
		}

		// 判断用户是否已经被锁定
		if (select.getPermission() <= 0) {
			user.setOther("该账户已被锁定");
			if (select.getPermission() == -3) {
				user.setOther("该账户未激活");
				return "user";
			}
			return Math.abs(select.getPermission()) == 1 ? "user" : "admin";
		}

		// 当进行管理员登陆的时候进行验证码的验证
		// 用户登陆是没有验证码的验证的
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (user.getPermission() == 2) {
			if (!session.getAttribute("ver").toString().equalsIgnoreCase((user.getCode()))) {
				user.setOther("验证码错误");
				return user.getPermission() == 1 ? "user" : "admin";
			}
		}

		// 密码形式转换
		user.setPassword(MD5Utils.getPassword(user.getPassword() + select.getCode()));
		// 统一对比用户名和密码
		if (select == null || !select.getPassword().equals(user.getPassword())) {
			user.setOther("用户名或密码错误");
			return user.getPermission() == 1 ? "user" : "admin";
		}

		// 判断界面传来的权限和相应的用户的权限是否相同
		if (user.getPermission() != select.getPermission()) {
			user.setOther("权限不足");
			return user.getPermission() == 1 ? "user" : "admin";
		}

		// 保存登陆信息到会话中
		session.setAttribute("user", select);

		// 根据不同的角色跳转的不同的页面
		return select.getPermission() == 1 ? "usershow" : "adminshow";
	}

	// 修改用户状态
	@Override
	public String permission(User user) {
		User select = select(user);
		// 冻结或解冻
		select.setPermission(-select.getPermission());
		update(select);
		return "show";
	}

	// 注销
	@Override
	public String signout(User user) {
		ServletActionContext.getRequest().getSession().invalidate();
		return user.getOther();
	}

}
