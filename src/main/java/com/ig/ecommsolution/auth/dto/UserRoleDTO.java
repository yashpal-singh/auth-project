/**
 * 
 */
package com.ig.ecommsolution.auth.dto;

import java.util.List;

/**
 * @author Yashpal.Singh
 *
 */
public class UserRoleDTO {

	private String userId;
	private List<String> roleIds;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<String> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}

}
