/**
 * 
 */
package com.ig.ecommsolution.auth.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Yashpal.Singh
 *
 */
@Document(collection = "user")
public class User {

	@Id
	private String id;
	private String name;
	@Indexed(unique=true)
	private String username;
	private String password;
	private byte[] image;

	public User() {

	}

	public User(User user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.username = user.getUsername();
		this.password = user.getPassword();
	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
