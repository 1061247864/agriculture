package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.User;
import com.pojo.UserAddressCount;

public interface UserMapper {

	int deleteByPrimaryKey(Integer userId);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer userId);

	int updateByPrimaryKeySelective(User record);

	List<UserAddressCount> findUserAddressCount();

	int updateByPrimaryKey(User record);

	User findUserByCode(@Param("userCode") String userCode);

	List<User> findAll(@Param("type") Integer type, @Param("user") User user);
}