package com.learning.oauth.resource.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableResourceServer
public class SpringCloudSecurityOauthResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSecurityOauthResourceServerApplication.class, args);
	}
	
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
