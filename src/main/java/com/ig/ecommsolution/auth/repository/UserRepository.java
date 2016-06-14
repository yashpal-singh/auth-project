/**
 * 
 */
package com.ig.ecommsolution.auth.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ig.ecommsolution.auth.domain.User;

/**
 * @author Yashpal.Singh
 *
 */
public interface UserRepository extends MongoRepository<User, String>{

	public List<User> findByUsername(String username);
	
}
