package com.mybatisspringboot.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybatisspringboot.MybatisSpringbootDemoApplication;
import com.mybatisspringboot.dao.UserDao;
import com.mybatisspringboot.domain.user;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= MybatisSpringbootDemoApplication.class)
public class RedisTest {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired UserDao userDao;
    @Test
    public void redisTest() throws JsonProcessingException {
        String userListJson =redisTemplate.boundValueOps("user.findAll").get();
        if (userListJson==null){
            List<user> all = userDao.findAll();
            ObjectMapper objectMapper = new ObjectMapper();
            String Listjson = objectMapper.writeValueAsString(all);
            redisTemplate.boundValueOps("user.findAll").set(Listjson);
            System.out.println("数据库中获取");
            System.out.println(Listjson);
        }
        System.out.println("redis中获取");
        System.out.println(userListJson);
    }
}
