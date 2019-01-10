package com.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.github.pagehelper.PageInfo;
import com.pojo.User;
import com.service.UserClientService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserClientService userClientService;

	@CrossOrigin(origins = { "http://172.20.10.4:8002", "null", "*" })
	@PostMapping(value = "/dologin")
	public Object findUserByCode(@RequestParam(value = "userCode") String userCode,
			@RequestParam(value = "password") String password) {
		UsernamePasswordToken passwordToken = new UsernamePasswordToken(userCode, password);
		Subject subject = SecurityUtils.getSubject();
		// IncorrectCredentialsException密码错误
		// UnknownAccountException用户名错误
		try {
			subject.login(passwordToken);
		} catch (UnknownAccountException e) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("message", "用户名不存在");
			return map;
		} catch (IncorrectCredentialsException e) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("message", "密码错误！");
			return map;
		} catch (Exception e){
			Map<String, String> map = new HashMap<String, String>();
			map.put("message", "异常错误,请联系管理员");
			return map;
		}
		return (User) subject.getPrincipal();
	}

	@GetMapping("/getuser/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		return userClientService.findUserById(id.toString());
	}

	@PostMapping("/registry")
	public Boolean userRegistry(User user) {
		String salt = UUID.randomUUID().toString();
		SimpleHash simpleHash = new SimpleHash("MD5", user.getPassword(), salt, 2);
		user.setSalt(salt);
		user.setPassword(simpleHash.toString());
		simpleHash = null;
		return userClientService.userRegistry(user);
	}

	/*
	 * public List<Role> findRoles(){
	 * 
	 * 
	 * }
	 */
	
	
	@PostMapping("/dofindUsers")
	public PageInfo<User> findUsers(User user, @RequestParam(value="currentPage",defaultValue="1")Integer currentPage)
	{
		return  userClientService.findUsers(user, currentPage);
	}
	@PostMapping("/dofindAdmins")
	public PageInfo<User> findAdmins(User user,  @RequestParam(value="currentPage",defaultValue="1") Integer currentPage)
	{
		return userClientService.findAdmins(user, currentPage);
	}

	@RequestMapping("/findbean")
	public String findbean(HttpSession session) {
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(session.getServletContext());
		String[] beanDefinitionNames = webApplicationContext.getBeanDefinitionNames();

		String names = "";
		for (String string : beanDefinitionNames) {
			names += string + "<br/>";
		}

		return names;
	}
	

}
