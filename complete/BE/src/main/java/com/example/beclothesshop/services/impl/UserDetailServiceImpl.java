package com.example.beclothesshop.services.impl;

import com.example.beclothesshop.model.entity.User;
import com.example.beclothesshop.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

//        System.out.println(user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName().name()))
//                .collect(Collectors.toList()));
        return UserServiceImpl.build(user);
    }
}
