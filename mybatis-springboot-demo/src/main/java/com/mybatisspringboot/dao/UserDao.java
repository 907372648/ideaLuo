package com.mybatisspringboot.dao;

import com.mybatisspringboot.domain.user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
public interface UserDao {
    List<user> findAll();
}
