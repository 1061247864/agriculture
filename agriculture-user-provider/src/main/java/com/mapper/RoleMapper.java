package com.mapper;

import java.util.List;

import com.pojo.Role;

public interface RoleMapper {

    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);


    Role selectByPrimaryKey(Integer roleId);
 
   List<Role> findRolesByUser(Integer userId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}