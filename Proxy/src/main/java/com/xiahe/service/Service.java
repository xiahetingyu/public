package com.xiahe.service;

import com.xiahe.entity.Entity;
import com.xiahe.entity.Page;
import org.springframework.ui.Model;

import java.util.List;

public interface Service<T extends Entity> {

    boolean insert(T t);

    boolean delete(T t);

    boolean update(T t);

    T select(T t);

    List<T> selects(Object... objects);

    boolean deletes(List<Integer> ids, T t);

    List<T> selectps(Model model, Page page);

}
