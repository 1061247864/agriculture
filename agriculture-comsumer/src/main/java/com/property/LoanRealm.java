package com.property;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;



public class LoanRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}
	/*@Autowired
	private UserMapper userMapper;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User userName = (User) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		List<Role> roles = userName.getRoles();
		List<Permission> permissions = userName.getPermissions();
		for (Role role : roles) {
			simpleAuthorizationInfo.addRole(role.getRoleName());
		}
		
		for (Permission permission : permissions) {
			simpleAuthorizationInfo.addStringPermission(permission.getPermissionName());
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
		User login = userMapper.findUserByCode(userCode);
		if (login == null) {
			return null;
		}
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(login, login.getPassword(),
				ByteSource.Util.bytes(login.getSalt()), this.getName());
		return simpleAuthenticationInfo;
	}
*/
}
