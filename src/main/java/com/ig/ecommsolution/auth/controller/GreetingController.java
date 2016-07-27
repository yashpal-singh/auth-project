/**
 * 
 */
package com.ig.ecommsolution.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ig.ecommsolution.auth.domain.User;
import com.ig.ecommsolution.auth.repository.UserRepository;

/**
 * @author Yashpal.Singh
 *
 */
@RestController
@RequestMapping("/gre")
public class GreetingController {

	@Autowired
	private UserRepository repository;

//	@PreAuthorize("hasRole('Tester')")
	@RequestMapping(value = "/greeting", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> greeting() {
		List<User> users = repository.findAll();
		return users;
	}

}
