package com.example.beclothesshop.services.impl;


import com.example.beclothesshop.common.exception.ResourceNotFoundException;
import com.example.beclothesshop.common.utils.GeneralUtils;
import com.example.beclothesshop.model.dto.LocalUser;
import com.example.beclothesshop.model.entity.User;
import com.example.beclothesshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("localUserDetailService")
public class LocalUserDetailService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	@Transactional
	public LocalUser loadUserByUsername(final String email) throws UsernameNotFoundException {
		System.out.println("22");
		User user = userService.findUserByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("User " + email + " was not found in the database");
		}
		return createLocalUser(user);
	}

	@Transactional
	public LocalUser loadUserById(Long id) {
		User user = userService.findUserById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return createLocalUser(user);
	}

	/**
	 * @param user
	 * @return
	 */
	private LocalUser createLocalUser(User user) {
		return new LocalUser(user.getEmail(), user.getPassword(), user.getActive(), true, true, true, GeneralUtils.buildSimpleGrantedAuthorities(user.getRoles()), user);
	}
}
