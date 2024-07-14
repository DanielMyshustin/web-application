package daniil.web.user.project.web_application.config;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.apache.shiro.mgt.SecurityManager;

import daniil.web.user.project.web_application.security.SecurityRealm;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@Configuration
@Import(SecurityConfig.class)
@SuppressFBWarnings(value = "URF_UNREAD_FIELD", justification = "Field is injected by Spring")
public class ShiroConfig {
	
	private final SecurityRealm securityRealm;
	
	public ShiroConfig(SecurityRealm securityRealm) {
		this.securityRealm = securityRealm;
	}
	
	@Bean(name = "customSecurityManager")
	public DefaultWebSecurityManager securityManager(SecurityRealm securityRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(securityRealm);
		return securityManager;
	}
	
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
		return advisor;
	}
	
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
	
	@SuppressWarnings("unused")
    public ShiroConfig() {
      this.securityRealm = null;
    }
}
