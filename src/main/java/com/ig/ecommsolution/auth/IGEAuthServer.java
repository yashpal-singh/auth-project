/**
 * 
 */
package com.ig.ecommsolution.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Yashpal.Singh
 *
 */
@SpringBootApplication
public class IGEAuthServer extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(IGEAuthServer.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoderBean() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(IGEAuthServer.class);
	}

}
