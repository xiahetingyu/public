package com.xiahe.tool;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisTools {
    private static SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> threadLocal;

    public static SqlSession openSqlSession() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    public static void closeSqlSession() {
        commit();
        SqlSession sqlSession = openSqlSession();
        sqlSession.close();
        threadLocal.remove();
    }

    public static void commit() {
        SqlSession sqlSession = openSqlSession();
        sqlSession.commit();
    }

    public static void rollback() {
        SqlSession sqlSession = openSqlSession();
        sqlSession.rollback();
    }

    public static <T> T getMapper(Class<T> mapper) {
        SqlSession sqlSession = openSqlSession();
        return sqlSession.getMapper(mapper);
    }

    static {
        String mybatis_config = "mybatis/mybatis.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(mybatis_config);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            inputStream.close();
            threadLocal = new ThreadLocal<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
