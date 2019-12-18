package com.example.datasource.datasources.controller;

import com.example.datasource.datasources.entity.db2.Role;
import com.example.datasource.datasources.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
 
    @Autowired
    private RoleService roleService;
 
    @GetMapping("/select/list")
    public List<Role> selectRoleList() {
        return this.roleService.selectRoleList();
    }
 
    @GetMapping("/save")
    public void saveRole(Role role) {
        this.roleService.saveRole(role);
    }
 
 
}