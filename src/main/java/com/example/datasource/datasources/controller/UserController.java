package com.example.datasource.datasources.controller;

import com.example.datasource.datasources.entity.db1.User;
import com.example.datasource.datasources.service.UserService;
import com.example.datasource.redis.CityInfo;
import com.example.datasource.redis.CityService;
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
    @Autowired
    private CityService cityService;
 
    @GetMapping("/select/list")
    public CityInfo selectUserList() {
        return  cityService.getCity(1,"12");
    }
 
    @GetMapping("/save")
    public void saveUser(User user) {
        this.cityService.addCity(1,"13");
    }
    @GetMapping("/delete")
    public void delete() {
        this.cityService.delete(1);
    }

}