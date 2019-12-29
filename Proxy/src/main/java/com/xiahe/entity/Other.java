package com.xiahe.entity;

//用于用户扩展
public class Other extends Entity {
    private String username;
    private double balance;
    private int count;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Other{" +
                "username='" + username + '\'' +
                ", balance=" + balance +
                ", count=" + count +
                "} " + super.toString();
    }

}
