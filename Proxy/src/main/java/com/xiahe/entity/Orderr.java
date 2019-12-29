package com.xiahe.entity;

//用于代理订单
public class Orderr extends Entity {
    private String username;
    private int count;
    private double amount;
    private int status;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
        return "Orderr{" +
                "username='" + username + '\'' +
                ", count=" + count +
                ", amount=" + amount +
                ", status=" + status +
                "} " + super.toString();
    }

}
