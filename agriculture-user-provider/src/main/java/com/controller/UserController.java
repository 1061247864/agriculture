package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.pojo.User;
import com.pojo.UserAddressCount;
import com.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// 根据id查询到用户
	@GetMapping("get/{id}")
	public User get(@PathVariable("id") String id) {
		return userService.findUserById(Integer.parseInt(id));
	}

	@PostMapping("/findadmins")
	public PageInfo<User> findAdmins(@RequestBody User user, @RequestParam("currentPage") Integer currentPage) {

		return userService.findAdmins(currentPage, user);
	}

	// 按条件翻页查询
	@PostMapping("/findusers")
	public PageInfo<User> findUsers(@RequestBody User user, @RequestParam("currentPage") Integer currentPage) {

		return userService.findUsers(currentPage, user);
	}

	// 根据账户查询用户
	@PostMapping("/findUserByCode")
	public User findUserByCode(@RequestParam(value = "userCode") String userCode) {
		return userService.findUserByCode(userCode);
	}

	@PostMapping("/userRegistry")
	public Boolean userRegistry(@RequestBody User user) {
		return userService.userRegistry(user);
	}

	@GetMapping("/findUserAddressCount")
	public List<UserAddressCount> findUserAddressCount() {
		return userService.findUserAddressCount();
	}

	@PostMapping("/isExistence")
	public Map<String, String> isExistence(@RequestParam("userCode") String userCode,
			@RequestParam("email") String email) {
		User userIsExistence = userService.userIsExistence(userCode, email);
		if (userIsExistence != null) {
			Map<String, String> map = new HashMap<String, String>();
			if (userCode.equals(userIsExistence.getUserCode())) {

				map.put("message", "用户名已存在！");
			} else if (userCode.equals(userIsExistence.getEmail())) {
				
				map.put("message", "用户名已存在！");
			}else if(email.equals(userIsExistence.getUserCode()))
			{
				map.put("message", "邮箱已存在！");
			}else if(email.equals(userIsExistence.getEmail())) {
				map.put("message", "邮箱已存在！");
			}
			return map;
		}
		return null;
	}

	@GetMapping("/updateUserStatus")
	public Boolean updateUserStatus(@RequestParam("userCode") String userCode) {
		if (userService.updateUserStatus(userCode) > 0) {
			return true;
		}
		return false;
	}
}
