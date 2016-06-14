/**
 * 
 */
package com.ig.ecommsolution.auth.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ig.ecommsolution.auth.domain.UserRole;

/**
 * @author Yashpal.Singh
 *
 */
public interface UserRoleRepository extends MongoRepository<UserRole, String>{

	public List<UserRole> findByUserId(String userId);
	
}
