/**
 * 
 */
package com.ig.ecommsolution.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ig.ecommsolution.auth.domain.Role;
import com.ig.ecommsolution.auth.domain.User;
import com.ig.ecommsolution.auth.domain.UserRole;
import com.ig.ecommsolution.auth.dto.UserRoleConvertor;
import com.ig.ecommsolution.auth.dto.UserRoleDTO;
import com.ig.ecommsolution.auth.repository.RoleRepository;
import com.ig.ecommsolution.auth.repository.UserRepository;
import com.ig.ecommsolution.auth.repository.UserRoleRepository;

@RestController()
@RequestMapping("/add")
public class AuthController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;
	

	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@RequestMapping(value = "/role", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Role addRole(@RequestBody Role role) {
		return roleRepository.save(role);
	}
	
	@RequestMapping(value = "/userrole", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserRole> addUserRole(@RequestBody UserRoleDTO dto) {
		List<UserRole> userRoles = UserRoleConvertor.convertFromDTO(dto);
		return userRoleRepository.save(userRoles);
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String test() {
		return ("Hello, Auth Server");
	}

}
