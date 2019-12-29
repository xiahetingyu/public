package com.xiahe.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiahe.entity.Item;
import com.xiahe.entity.Product;
import com.xiahe.service.ProductServiceImp;
import com.xiahe.service.Service;

//购物车
@SuppressWarnings("serial")
public class CarAction extends ActionSupport {
	private HttpSession session = ServletActionContext.getRequest().getSession();
	private Service<Product> service = new ProductServiceImp();
	private Product product;

	// 添加商品项
	public String insert() {
		// 初始化环境
		init();

		// 存在订单项
		boolean containsKey = items.containsKey(product.getId() + "");
		Item item = containsKey ? items.get(product.getId() + "") : new Item();
		item.setCount(item.getCount() + 1);
		// 不存在该购物项
		if (!containsKey) {
			item.setProduct(service.select(product));
		}
		items.put(product.getId() + "", item);

		// 计算额外值
		compute();
		return "cart_list.jsp";
	}

	// 删除
	public String delete() {
		init();
		items.remove(product.getId() + "");
		compute();
		return "cart_list.jsp";
	}

	// 修改
	public String update() {
		init();
		Item item = items.get(product.getId() + "");
		int count = item.getCount() + product.getC_id();
		item.setCount(count > 0 ? count : 1);
		compute();
		return "cart_list.jsp";
	}

	// 初始化环境
	@SuppressWarnings("unchecked")
	private void init() {
		car = session.getAttribute("car") == null ? new HashMap<String, Object>()
				: (HashMap<String, Object>) session.getAttribute("car");
		items = car.containsKey("items") ? (HashMap<String, Item>) car.get("items") : new HashMap<String, Item>();
		car.put("items", items);
		session.setAttribute("car", car);
	}

	// 计算额外值
	private void compute() {
		// 计算
		double total = 0, save = 0;
		for (Item item : items.values()) {
			item.setSubtotal(item.getCount() * item.getProduct().getPrice());
			total += item.getSubtotal();
			save += item.getCount() * item.getProduct().getDprice();
		}
		// 存值
		car.put("total", total);
		car.put("save", total - save);
	}

	// session中存在的购物车
	private Map<String, Object> car;
	// 购物车中的购物项
	private Map<String, Item> items;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
