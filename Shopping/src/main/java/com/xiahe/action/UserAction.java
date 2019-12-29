package com.xiahe.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xiahe.entity.User;
import com.xiahe.service.UserService;
import com.xiahe.service.UserServiceImp;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport {
	private UserService service = new UserServiceImp();
	private User user;
	private List<User> users;

	public String signup() {
		return service.signup(user);
	}

	public String signin() {
		return service.signin(user);
	}

	public String signout() {
		return service.signout(user);
	}

	public String ver() {
		return service.ver();
	}

	public String verEmail() {
		return service.verEmail(user);
	}

	public String show() {
		users = service.selects();
		return "show.jsp";
	}

	public String permission() {
		return service.permission(user);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
