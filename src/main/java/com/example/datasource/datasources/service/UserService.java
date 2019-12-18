package com.example.datasource.datasources.service;
 

import com.example.datasource.datasources.entity.db1.User;

import java.util.List;

public interface UserService {
 
    List<User> selectUserList();
 
    void saveUser(User user);
 
}