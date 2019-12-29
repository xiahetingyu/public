package com.xiahe.service;

import java.util.List;

import com.xiahe.dao.ClazzDao;
import com.xiahe.entity.Clazz;

public class ClazzServiceImp extends ServiceImp<Clazz> implements ClazzService {

	public ClazzServiceImp() {
		super(ClazzDao.class);
	}

	// 覆盖默认的删除操作
	@Override
	public boolean delete(Clazz t) {
		// 当查到有子项时拒绝删除
		List<Clazz> selects = selects("where p = " + t.getId());
		if (selects.size() > 0) {
			return false;
		}
		return super.delete(t);
	}

	// 根据等级查询
	@Override
	public List<Clazz> selectsLevel(String level) {
		return selects("where level = " + level);
	}

	@Override
	public List<Clazz> selectsAll() {
		List<Clazz> first = selects("where level = 1");
		for (Clazz clazz : first) {
			clazz.setClazzs(selects("where p = " + clazz.getId()));
		}
		return first;
	}

}
