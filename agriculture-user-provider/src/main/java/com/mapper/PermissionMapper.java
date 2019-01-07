package com.mapper;

import java.util.List;

import com.pojo.Permission;

public interface PermissionMapper {


    int deleteByPrimaryKey(Integer perId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer perId);
    int updateByPrimaryKeySelective(Permission record);

    List<Permission> findPermissionByUser(Integer userid);
    
    
    int updateByPrimaryKey(Permission record);
}