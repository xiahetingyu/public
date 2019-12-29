package com.xiahe.service;

import java.util.List;

import com.xiahe.dao.Dao;
import com.xiahe.entity.Entity;
import com.xiahe.tool.MybatisTools;

public class ServiceImp<T extends Entity> implements Service<T> {
	protected Class<? extends Dao<T>> clazz;

	public ServiceImp(Class<? extends Dao<T>> clazz) {
		this.clazz = clazz;
	}

	@Override
	public boolean insert(T t) {
		try {
			Dao<T> dao = MybatisTools.getMapper(clazz);
			dao.insert(t);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			MybatisTools.rollback();
			return false;
		} finally {
			MybatisTools.closeSqlSession();
		}
	}

	@Override
	public boolean delete(T t) {
		try {
			Dao<T> dao = MybatisTools.getMapper(clazz);
			dao.delete(t);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			MybatisTools.rollback();
			return false;
		} finally {
			MybatisTools.closeSqlSession();
		}
	}

	@Override
	public boolean update(T t) {
		try {
			Dao<T> dao = MybatisTools.getMapper(clazz);
			dao.update(t);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			MybatisTools.rollback();
			return false;
		} finally {
			MybatisTools.closeSqlSession();
		}
	}

	@Override
	public T select(T t) {
		Dao<T> dao = MybatisTools.getMapper(clazz);
		T select = dao.select(t);
		MybatisTools.closeSqlSession();
		return select;
	}

	@Override
	public List<T> selects(Object... objects) {
		Dao<T> dao = MybatisTools.getMapper(clazz);
		List<T> selects = null;
		if (objects.length == 0) {
			selects = dao.selects("");
		}
		if (objects.length > 0) {
			selects = dao.selects(objects);
		}
		MybatisTools.closeSqlSession();
		return selects;
	}

}
