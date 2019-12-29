package com.xiahe.dao;

import com.xiahe.entity.Entity;

import java.util.List;

public interface Dao<T extends Entity> {

	void insert(T t);

	void delete(T t);

	void update(T t);

	T select(T t);

	List<T> selects(Object... objects);

}
