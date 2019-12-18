package com.example.datasource.datasources.mapper.db1;
 

import com.example.datasource.datasources.entity.db1.User;

import java.util.List;

public interface UserMapper {
 
    List<User> selectUserList();
 
    void saveUser(User user);
 
}