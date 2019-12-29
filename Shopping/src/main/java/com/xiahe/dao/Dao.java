package com.xiahe.dao;

import java.util.List;

import com.xiahe.entity.Entity;

public interface Dao<T extends Entity> {

	void insert(T t);

	void delete(T t);

	void update(T t);

	T select(T t);

	List<T> selects(Object... objects);

}
