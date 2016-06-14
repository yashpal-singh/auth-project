/**
 * 
 */
package com.ig.ecommsolution.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * @author Yashpal.Singh
 *
 */
@SpringBootApplication
public class IGEAuthServer extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(IGEAuthServer.class, args);

		// String authorization = "Basic "
		// + new String(Base64Utils.encode("restapp:restappsecret".getBytes()));
		// System.out.println(authorization);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(IGEAuthServer.class);
	}

}
