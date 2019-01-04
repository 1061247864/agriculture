package com.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.pojo.User;
import com.service.UserClientService;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
 private UserClientService  userClientService;
  

  @PostMapping("/dologin")
  public User findUserByCode(String userCode,String password)
  {
	  UsernamePasswordToken passwordToken = new UsernamePasswordToken(userCode, password);
	  Subject subject= SecurityUtils.getSubject();
	  subject.login(passwordToken);
	  return (User)subject.getPrincipal();
  }
 
  @GetMapping("/getuser/{id}")
  public User getUserById(@PathVariable("id")Integer id)
  { 
	 return  userClientService.findUserById(id.toString());
  }
  
  @RequestMapping("/findbean")
  public String findbean(HttpSession session)
  {
	  WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
	  String[] beanDefinitionNames = webApplicationContext.getBeanDefinitionNames();
 
 String names="";
 for (String string : beanDefinitionNames) {
	 names+=string+"<br/>";
}
  
  return names;
  }
  
}
