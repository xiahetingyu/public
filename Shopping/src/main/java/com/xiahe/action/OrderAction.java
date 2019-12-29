package com.xiahe.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiahe.entity.Detail;
import com.xiahe.entity.Item;
import com.xiahe.entity.Order;

@SuppressWarnings("serial")
public class OrderAction extends ActionSupport {
	HttpSession session = ServletActionContext.getRequest().getSession();
	private Order order;

	// 把购物车生成订单
	@SuppressWarnings("unchecked")
	public String gorder() {
		order = new Order();// 生成订单对象

		// 获取购物车数据
		Map<String, Object> car = (Map<String, Object>) session.getAttribute("car");
		Map<String, Item> items = (Map<String, Item>) car.get("items");

		// 由购物车项转换为订单项
		List<Detail> details = new ArrayList<Detail>();
		for (Item item : items.values()) {
			Detail detail = new Detail();
			detail.setCount(item.getCount());
			detail.setName(item.getProduct().getName());
			detail.setP_id(item.getProduct().getC_id());
			detail.setSubtotal(item.getSubtotal());
			detail.setProduct(item.getProduct());
			details.add(detail);
		}
		order.setDetails(details);
		order.setTotal((double) car.get("total"));

		// 清空购物车

		return "order_info.jsp";
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
