package com.property;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.pojo.Permission;
import com.pojo.Role;
import com.pojo.User;
import com.service.UserClientService;
import com.util.MySimpleByteSource;



public class LoanRealm extends AuthorizingRealm {
	
	/*public LoanRealm() {
		HashedCredentialsMatcher hashedCredentialsMatcher =new HashedCredentialsMatcher("MD5");
		hashedCredentialsMatcher.setHashIterations(2);
		super.setCredentialsMatcher(hashedCredentialsMatcher);
	}*/

	@Autowired
	private UserClientService userClientService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		 User user=(User) principals.getPrimaryPrincipal();
		 if(user!=null)
		 {
			 Set<String>roless = new HashSet<String>();
			 List<Role> roles = user.getRoles();
			 for (Role role : roles) {
				 roless.add(role.getRoleName());
			}
			 List<Permission> lPermissions = user.getPermissions();
			 
			 Set<String>sPermissions = new HashSet<String>();
			 for (Permission permission : lPermissions) {
				 sPermissions.add(permission.getPreMenuName());
			}
			 simpleAuthorizationInfo.addRoles(roless);
			 simpleAuthorizationInfo.addStringPermissions(sPermissions);
		 }
		
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
				new MySimpleByteSource(login.getSalt()), this.getName());
		simpleAuthenticationInfo.setPrincipals(new MySimplePrincipalCollection(login,this.getName()));
		return simpleAuthenticationInfo;
	}

}
