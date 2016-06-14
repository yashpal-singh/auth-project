/**
 * 
 */
package com.ig.ecommsolution.auth.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ig.ecommsolution.auth.domain.Role;
import com.ig.ecommsolution.auth.domain.User;
import com.ig.ecommsolution.auth.domain.UserRole;
import com.ig.ecommsolution.auth.repository.UserRepository;
import com.ig.ecommsolution.auth.repository.UserRoleRepository;

/**
 * @author Yashpal.Singh
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<User> users = userRepository.findByUsername(username);
		if(users == null || users.isEmpty())
			throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
		
		return new UserRepositoryUserDetails(users.get(0), userRoleRepository);
		
	}
	
	private final static class UserRepositoryUserDetails extends User implements UserDetails {

		private static final long serialVersionUID = 1L;
		
		private UserRoleRepository repository;
		
		private UserRepositoryUserDetails(User user, UserRoleRepository repository) {
			super(user);
			this.repository = repository;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			List<UserRole> userRoles = repository.findByUserId(getId());
			List<Role> roles = new ArrayList<Role>();
			for(UserRole userRole : userRoles) {
				roles.add(userRole.getRole());
			}
			return roles;
		}

		@Override
		public boolean isAccountNonExpired() {			
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}
		
	}

}
