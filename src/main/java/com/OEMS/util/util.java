package com.OEMS.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class util {

    private static SqlSessionFactory factory = null;


    static {
        String config = "mybatis.xml";
        try {
            InputStream in = Resources.getResourceAsStream(config);
            factory = new SqlSessionFactoryBuilder().build(in);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取SqlSession对象
    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        if (factory != null) {
            sqlSession = factory.openSession(true);
        }
        return sqlSession;
    }
}

