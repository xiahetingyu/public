package com.xiahe.service;

import java.util.List;

import com.xiahe.entity.Entity;

public interface Service<T extends Entity> {

	boolean insert(T t);

	boolean delete(T t);

	boolean update(T t);

	T select(T t);

	List<T> selects(Object... objects);

}
