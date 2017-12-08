package com.learning.oauth.resource.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableResourceServer
public class SpringCloudSecurityOauthResourceServerApplication {
	
	@Autowired
	private ResourceServerProperties properties;
	
	@Bean
	public ResourceServerTokenServices myResourceServerTokenServices() {
		return new CustomUserInfoTokenService(properties.getUserInfoUri(), properties.getClientId());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSecurityOauthResourceServerApplication.class, args);
	}
	
	@PreAuthorize("#oauth2.hasScope('toll_read') and hasAuthority('ROLE_OPERATOR')")
	@RequestMapping("/reports")
	public List<Data> getReport() {
		List<Data> l = new ArrayList<>();
		l.add(new Data("abc"));
		l.add(new Data("def"));
		l.add(new Data("ghi"));
		return l;
	}
	
	public class Data {
		
		public String name;

		public Data(String name) {
			super();
			this.name = name;
		}
		
	}
}
