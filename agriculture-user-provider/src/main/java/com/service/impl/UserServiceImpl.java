package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUserById(Integer id) {

		return userMapper.selectByPrimaryKey(id);
	}

	public PageInfo<User> findAdmins(Integer currentPage, User user) {
		PageHelper.startPage(currentPage, 2);
		List<User> findAll = userMapper.findAll(0, user);
		PageInfo<User> pageInfo = new PageInfo<>(findAll);
		return pageInfo;

	}
	
	public PageInfo<User> findUsers(Integer currentPage, User user) {
		PageHelper.startPage(currentPage, 2);
		List<User> findAll = userMapper.findAll(1, user);
		PageInfo<User> pageInfo = new PageInfo<>(findAll);
		return pageInfo;

	}

}
