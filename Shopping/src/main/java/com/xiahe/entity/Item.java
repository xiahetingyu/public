package com.xiahe.entity;

//购物车项
@SuppressWarnings("serial")
public class Item extends Entity {
	private Product product;
	private int count;
	private double subtotal;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	@Override
	public String toString() {
		return "Item [product=" + product + ", count=" + count + ", subtotal=" + subtotal + "]";
	}

}
