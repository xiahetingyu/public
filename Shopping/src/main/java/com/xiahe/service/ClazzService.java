package com.xiahe.service;

import java.util.List;

import com.xiahe.entity.Clazz;

public interface ClazzService extends Service<Clazz> {

	List<Clazz> selectsLevel(String level);

	List<Clazz> selectsAll();

}
