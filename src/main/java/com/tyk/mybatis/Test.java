package com.tyk.mybatis;

import com.tyk.mybatis.entity.Category;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: tyk
 * @Date: 2019/9/20 14:16
 * @Description:
 */

public class Test {
    public static void main(String[] args) throws IOException {
        String resources = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<Category> categories = sqlSession.selectList("query");

        for (Category category : categories) {
            System.out.println(categories);
        }
    }
}
