/**
 * 
 */
package com.ig.ecommsolution.auth.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ig.ecommsolution.auth.domain.Role;

/**
 * @author Yashpal.Singh
 *
 */
public interface RoleRepository extends MongoRepository<Role, String> {

}
