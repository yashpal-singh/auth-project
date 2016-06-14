/**
 * 
 */
package com.ig.ecommsolution.auth.dto;

import java.util.ArrayList;
import java.util.List;

import com.ig.ecommsolution.auth.domain.Role;
import com.ig.ecommsolution.auth.domain.UserRole;

/**
 * @author Yashpal.Singh
 *
 */
public class UserRoleConvertor {

	public static List<UserRole> convertFromDTO(UserRoleDTO dto) {
		
		List<UserRole> userRoles = new ArrayList<UserRole>();
		for(String roleId : dto.getRoleIds()) {
			UserRole userRole = new UserRole();
			Role role = new Role();
			role.setId(roleId);
			
			userRole.setRole(role);
			userRole.setUserId(dto.getUserId());
			
			userRoles.add(userRole);
		}
		return userRoles;
		
	}
	
}
