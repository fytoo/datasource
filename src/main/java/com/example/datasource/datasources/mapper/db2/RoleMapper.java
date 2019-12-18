package com.example.datasource.datasources.mapper.db2;
 

import com.example.datasource.datasources.entity.db2.Role;

import java.util.List;

public interface RoleMapper {
 
    List<Role> selectRoleList();
 
    void saveRole(Role role);
}