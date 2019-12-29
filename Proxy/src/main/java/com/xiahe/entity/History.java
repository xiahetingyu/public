package com.xiahe.entity;

//用于代理历史
public class History extends Entity {
    private String username;
    private String proxye;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProxye() {
        return proxye;
    }

    public void setProxye(String proxye) {
        this.proxye = proxye;
    }

    @Override
    public String toString() {
        return "History{" +
                "username='" + username + '\'' +
                ", proxye='" + proxye + '\'' +
                "} " + super.toString();
    }

}
