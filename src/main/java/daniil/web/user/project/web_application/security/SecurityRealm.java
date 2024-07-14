package daniil.web.user.project.web_application.security;

import java.util.Optional;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import daniil.web.user.project.web_application.model.User;
import daniil.web.user.project.web_application.service.UserService;

@Component
public class SecurityRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		Optional<User> optionalUser = userService.findByUsername(username);
		
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			String name = user.getUsername();
			
			System.out.print(name);
		}
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		
		Optional<User> optionalUser = userService.findByUsername(username);
		
		if (!optionalUser.isPresent()) {
			throw new UnknownAccountException("USer not found with Username: " + username);
		}
		
		User user = optionalUser.get();
		String password = user.getPassword();
		
		return new SimpleAuthenticationInfo(username, password, getName());
	}
}
