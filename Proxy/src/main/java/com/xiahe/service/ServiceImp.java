package com.xiahe.service;

import com.xiahe.dao.Dao;
import com.xiahe.entity.Entity;
import com.xiahe.entity.Page;
import com.xiahe.tool.MybatisTools;
import org.springframework.ui.Model;

import java.util.List;

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

    @Override
    public boolean deletes(List<Integer> ids, T t) {
        try {
            Dao<T> dao = MybatisTools.getMapper(clazz);
            try {
                for (Integer i : ids) {
                    t.setId(i);
                    delete(t);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
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
    public List<T> selectps(Model model, Page page) {
        Dao<T> dao = MybatisTools.getMapper(clazz);
        List<T> selects = dao.selects("where " + page.getCondition() + " like '%" + page.getContent() + "%'");
        page.setCount(selects.size() % page.getSize() == 0 ? selects.size() / page.getSize() : selects.size() / page.getSize() + 1);
        //验证范围
        page.setIndex(page.getIndex() > page.getCount() - 1 ? page.getCount() - 1 : page.getIndex());
        page.setIndex(page.getIndex() < 0 ? 0 : page.getIndex());
        selects = selects("where " + page.getCondition() + " like '%" + page.getContent() + "%' " + "order by time desc limit " + (page.getIndex() * page.getSize()) + "," + page.getSize());
        return selects;
    }

}
