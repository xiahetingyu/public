package com.xiahe.service;

import com.xiahe.entity.User;

public interface UserService extends Service<User> {

	// 获取验证码
	String ver();

	// 注册
	String signup(User user);

	// 登陆
	String signin(User user);

	// 验证邮箱
	String verEmail(User user);

	// 修改状态
	String permission(User user);

	// 注销
	String signout(User user);

}
