package com.xiahe.entity;

//用于充值历史
public class Recharge extends Entity {
    private String username;
    private double amount;
    private int status;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Recharge{" +
                "username='" + username + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                "} " + super.toString();
    }

}
