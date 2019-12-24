package com.example.datasource.datasources.controller;

import com.example.datasource.datasources.entity.db1.User;
import com.example.datasource.datasources.service.UserService;
import com.example.datasource.redis.CityInfo;
import com.example.datasource.redis.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/user")
@Validated
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

    @PostMapping(value="/getException" ,produces = "application/json;charset=UTF-8")
    public String getException(@Valid @RequestBody User user) {
        System.out.println(user.getName());
        return  "validate1";
    }
}