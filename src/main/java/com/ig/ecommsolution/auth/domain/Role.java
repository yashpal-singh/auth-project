/**
 * 
 */
package com.ig.ecommsolution.auth.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author Yashpal.Singh
 *
 */
@Document(collection = "role")
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = -7105033534418572448L;
	
	@Id
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAuthority() {
		return name;
	}

}
