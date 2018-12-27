package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper  userMapper;
	@Override
	public User findUserById(Integer id) {
		
		return userMapper.selectByPrimaryKey(id);
	}

	
}
