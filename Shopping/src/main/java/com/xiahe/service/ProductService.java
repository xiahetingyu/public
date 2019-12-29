package com.xiahe.service;

import java.util.List;
import java.util.Map;

import com.xiahe.entity.Page;
import com.xiahe.entity.Product;

public interface ProductService extends Service<Product> {

	boolean insert(Product product, Object... objects);

	boolean update(Product product, Object... objects);

	List<Product> selectls(Product product);

	// 一级页面
	Map<String, Object> index();

	// 二级页面
	Map<String, Object> second(Page page);

}
