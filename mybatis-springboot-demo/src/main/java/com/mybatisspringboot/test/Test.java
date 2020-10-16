package com.mybatisspringboot.test;

import com.mybatisspringboot.MybatisSpringbootDemoApplication;
import com.mybatisspringboot.dao.UserDao;
import com.mybatisspringboot.domain.user;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= MybatisSpringbootDemoApplication.class)
public class Test {
    @Autowired
    private UserDao userDao;
    @org.junit.Test
    public void findAllTest(){
        List<user> all = userDao.findAll();
        System.out.println(all);
    }
}
