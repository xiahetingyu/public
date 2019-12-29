package com.xiahe.dao;

import java.util.List;

import com.xiahe.entity.Product;

public interface ProductDao extends Dao<Product> {

	List<Product> selectps(Object... objects);

}
