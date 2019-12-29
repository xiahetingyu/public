package com.xiahe.entity;

//用于登陆注册
public class User extends Entity {
    private String nickname;// 昵称
    private String username;// 手机号
    private String password;// 密码
    private String path;// 头像路径
    private String phoneCode;// 手机验证码
    private int permission;// 权限状态

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", path='" + path + '\'' +
                ", phoneCode='" + phoneCode + '\'' +
                ", permission=" + permission +
                "} " + super.toString();
    }

}
