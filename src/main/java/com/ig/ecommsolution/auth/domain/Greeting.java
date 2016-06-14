/**
 * 
 */
package com.ig.ecommsolution.auth.domain;

/**
 * @author Yashpal.Singh
 *
 */
public class Greeting {

	private final long id;

	private final String content;

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

}
