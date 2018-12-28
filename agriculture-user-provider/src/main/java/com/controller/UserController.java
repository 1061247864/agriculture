package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.pojo.User;
import com.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("get/{id}")
	public User get(@PathVariable("id") String id) {
		return userService.findUserById(Integer.parseInt(id));
	}
	
	@PostMapping("/findadmins")
	public PageInfo<User> findAdmins(User user,@RequestParam("currentPage")Integer currentPage){
		
		return userService.findAdmins(currentPage, user);
	}
	@PostMapping("/findusers")
	public PageInfo<User> findUsers(User user,@RequestParam("currentPage")Integer currentPage){
		
		return userService.findAdmins(currentPage, user);
	}
}
