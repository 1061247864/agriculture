package com.controller;

import java.util.HashMap;

import java.util.Map;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
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
import com.util.MailClient;
import com.util.UserStatusException;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserClientService userClientService;
	@Autowired
	MailClient maulClient;

/*	@CrossOrigin(origins = { "http://172.20.10.4:8002", "null", "*" })*/
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
		}catch (UserStatusException e) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("message", "账户未激活,请前去您的邮箱激活账户！");
			return map;
		} catch (Exception e) {
			if(e.getCause() instanceof UserStatusException)
			{
				Map<String, String> map = new HashMap<String, String>();
				map.put("message","账户未激活,请前去您的邮箱激活账户！");
				return map;
			}
			Map<String, String> map = new HashMap<String, String>();
			map.put("message", "异常错误,请联系管理员");
			return map;
		}
		
		/*Map<String ,Object> map = new HashMap<String ,Object>();
		map.put("JSESSION", session.getId());
		map.put("userinfo", (User) subject.getPrincipal());*/
		
		return (User) subject.getPrincipal();
	}
	
	@GetMapping("/getuser/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		return userClientService.findUserById(id.toString());
	}

	@PostMapping("/registry")
	@Transactional
	public Map userRegistry(User user) {
		Map<String ,String> map = new HashMap<String ,String>();
		String salt = UUID.randomUUID().toString();
		SimpleHash simpleHash = new SimpleHash("MD5", user.getPassword(), salt, 2);
		user.setSalt(salt);
		user.setPassword(simpleHash.toString());
		user.setStatus(0);
		Boolean userRegistry = userClientService.userRegistry(user);
		try {
			maulClient.sendMail(user.getEmail(),user.getUserCode());
		} catch (MessagingException e) {
			map.put("message", "服务器繁忙发,请稍后重试");
			map.put("isregistry", "false");
			return map;
		} catch (MailSendException e) {
			map.put("message", "邮箱号不存在，请输入正确的邮箱号！");
			map.put("isregistry", "false");
			return map;
		}catch (Exception e) {
			map.put("message", "服务器繁忙发,请稍后重试");
			map.put("isregistry", "false");
			return map;
		}
		simpleHash = null;
		if(userRegistry) {
		map.put("isregistry", "true");
		map.put("message", "恭喜您，注册成功请前去 邮箱激活您的账户！");
		}
		return map;
	}

	/*
	 * public List<Role> findRoles(){
	 * 
	 * 
	 * }
	 */
	@GetMapping("sendMail")
    public String sendEmail(@RequestParam("toEmail")String toEmail) throws MessagingException
    {
    	try {
    		maulClient.sendMail(toEmail, "12332112345657");
		} catch (Exception e) {
			  return "error";
		}
      return "success";
    }

	@PostMapping("/dofindUsers")
	public PageInfo<User> findUsers(User user,
			@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage) {
		return userClientService.findUsers(user, currentPage);
	}

	@PostMapping("/dofindAdmins")
	public PageInfo<User> findAdmins(User user,
			@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage) {
		return userClientService.findAdmins(user, currentPage);
	}

	@GetMapping("/getCurrentUser")
	public User getCurrentUser() {
	//	DefaultWebSessionManager sessionManager = (DefaultWebSessionManager)getSessionManager();
		Subject subject = SecurityUtils.getSubject();
		User principal = (User) subject.getPrincipal();

		Map<String, Object> map = new HashMap<String, Object>();
		/*map.put("JSESSION", session.getId());
		map.put("user", principal);*/
		return principal == null ? null : principal;
	}

	public SessionManager  getSessionManager() {
		DefaultWebSecurityManager securityManager =(DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
		return securityManager.getSessionManager();
	
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
