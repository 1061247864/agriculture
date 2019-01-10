package com.fallback;

import com.pojo.User;
import com.service.UserClientService;

public class HystrixFallBack {

	public User findUserById(String id) {
		User  user= new User();
		
		user.setUserCode("");
		return user;
	}

	public User findUserByCode(String userCode) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean userRegistry(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
