package webx.app1.module.action;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import webx.po.User;
import webx.service.user.UserService;

import javax.annotation.Resource;

/**
 * Created by Garson in 22:41 2017/11/10
 * Description :
 */
public class MyRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		System.out.println("author realm");
		String userName = (String) principalCollection.getPrimaryPrincipal();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.setRoles(userService.getRoles(userName));
		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		System.out.println("authen realm");
		String userName = (String) authenticationToken.getPrincipal();
		User user = userService.selectByName(userName);
		if(user != null){
			return new SimpleAuthenticationInfo(user.getUserName() ,user.getPassword() ,"xx");
		}else {
			return null;
		}
	}
}
