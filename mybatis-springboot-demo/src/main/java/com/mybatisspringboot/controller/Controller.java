package com.mybatisspringboot.controller;

import com.mybatisspringboot.dao.UserDao;
import com.mybatisspringboot.domain.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/demo")
    @ResponseBody
    public List<user> findAll(){
        return userDao.findAll();
    }
    @RequestMapping("/a")
    @ResponseBody
    public String a(){
        return "hello";
    }
}
