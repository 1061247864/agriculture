package com.service;

import com.github.pagehelper.PageInfo;
import com.pojo.User;

public interface UserService {
   public User findUserById(Integer id);
   PageInfo<User> findAdmins(Integer currentPage, User user);
   public PageInfo<User> findUsers(Integer currentPage, User user);
}
