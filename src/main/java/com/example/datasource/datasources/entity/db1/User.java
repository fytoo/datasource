package com.example.datasource.datasources.entity.db1;

import javax.validation.constraints.Size;

public class User {
 
    public Integer id;
    @Size(min = 1,max = 10,message = "姓名长度必须为1到10")
    public String name;
 
    public User() {
    }
 
    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
}