package com.example.datasource.datasources.service;
 
import com.example.datasource.datasources.entity.db2.Role;

import java.util.List;

public interface RoleService {
 
    List<Role> selectRoleList();
 
    void saveRole(Role role);
 
}