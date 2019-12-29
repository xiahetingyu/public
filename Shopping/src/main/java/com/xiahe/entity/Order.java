package com.xiahe.entity;

import java.util.List;

@SuppressWarnings("serial")
public class Order extends Entity {
	private String email;
	private int a_id;
	private String orderr;
	private double total;
	private int status;
	private List<Detail> details;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public String getOrderr() {
		return orderr;
	}

	public void setOrderr(String orderr) {
		this.orderr = orderr;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Detail> getDetails() {
		return details;
	}

	public void setDetails(List<Detail> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Order [email=" + email + ", a_id=" + a_id + ", orderr=" + orderr + ", total=" + total + ", status="
				+ status + ", details=" + details + "]";
	}

}
