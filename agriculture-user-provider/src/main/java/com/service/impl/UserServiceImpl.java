package com.service.impl;

import java.util.List;
import java.util.UUID;

import org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.PermissionMapper;
import com.mapper.RoleMapper;
import com.mapper.UserMapper;
import com.pojo.Permission;
import com.pojo.Role;
import com.pojo.User;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private PermissionMapper permissionMapper;

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

	@Override
	public User findUserByCode(String userCode) {
		return userMapper.findUserByCode(userCode);
	}

	@Override
	public List<Role> findRolesByUser(Integer userid) {
		return roleMapper.findRolesByUser(userid);
	}

	@Override
	public List<Permission> findPermissionByUser(Integer userid) {
		return permissionMapper.findPermissionByUser(userid);
	}

	@Override
	public Boolean userRegistry(User user) {
		int insert = userMapper.insertSelective(user);
		if (insert > 0) {
			return true;
		}
		return false;
	};
}
