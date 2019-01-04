package com.property;


import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.pojo.Permission;
import com.pojo.Role;
import com.pojo.User;
import com.service.UserClientService;



public class LoanRealm extends AuthorizingRealm {


	@Autowired
	private UserClientService userClientService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
	
		
		return simpleAuthorizationInfo;
	}
	@Override
	public String getName() {
		return "myRealm";
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userCode = (String) token.getPrincipal();
		User login = userClientService.findUserByCode(userCode);
		if (login == null) {
			return null;
		}
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(login, login.getPassword(),
				ByteSource.Util.bytes(login.getSalt()), this.getName());
		return simpleAuthenticationInfo;
	}

}
