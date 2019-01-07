package com.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pojo.Permission;
import com.pojo.Role;
import com.pojo.User;

public interface UserService {
   public User findUserById(Integer id);
   PageInfo<User> findAdmins(Integer currentPage, User user);
   public PageInfo<User> findUsers(Integer currentPage, User user);
   public User findUserByCode(String userCode);
   public List<Permission> findPermissionByUser(Integer userid);
   public List<Role> findRolesByUser(Integer userid);
   
   public Boolean userRegistry(User user);
}
