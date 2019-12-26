package com.example.datasource.datasources.entity.db1;

import javax.validation.constraints.*;
import java.io.Serializable;

public class User implements Serializable {
 
    public Integer id;
    @Size(min = 1,max = 10,message = "姓名长度必须为1到10")
    public String name;

    @Min(value = 1,message = "年纪输入最小为1")
    @Max(value = 50,message = "年纪输入最大为50")
    @NotNull(message="年纪不能为空")
    public Integer age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}