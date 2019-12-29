package com.xiahe.entity;

@SuppressWarnings("serial")
public class Detail extends Entity {
	private String orderr;
	private int p_id;
	private String name;
	private int count;
	private double subtotal;
	private Product product;

	public String getOrderr() {
		return orderr;
	}

	public void setOrderr(String orderr) {
		this.orderr = orderr;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Detail [orderr=" + orderr + ", p_id=" + p_id + ", name=" + name + ", count=" + count + ", subtotal="
				+ subtotal + "]";
	}

}
