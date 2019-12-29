package com.xiahe.entity;

@SuppressWarnings("serial")
public class User extends Entity {
	private String email;// 邮箱
	private String nickname;// 昵称
	private String password;// 密码
	private int permission;// 权限
	private String code;// 激活码

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", nickname=" + nickname + ", password=" + password + ", permission="
				+ permission + ", code=" + code + "]";
	}

}
