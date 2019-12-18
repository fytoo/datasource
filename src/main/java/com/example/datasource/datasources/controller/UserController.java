package com.example.datasource.datasources.controller;

import com.example.datasource.datasources.entity.db1.User;
import com.example.datasource.datasources.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
 
    @Autowired
    private UserService userService;
 
    @GetMapping("/select/list")
    public List<User> selectUserList() {
        return this.userService.selectUserList();
    }
 
    @GetMapping("/save")
    public void saveUser(User user) {
        this.userService.saveUser(user);
    }
 
 
}