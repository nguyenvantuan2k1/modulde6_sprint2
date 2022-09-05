package com.example.beclothesshop.services;


import com.example.beclothesshop.common.exception.UserAlreadyExistAuthenticationException;
import com.example.beclothesshop.common.request.SignupRequest;
import com.example.beclothesshop.model.dto.LocalUser;
import com.example.beclothesshop.model.entity.User;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;

import java.util.Map;
import java.util.Optional;

public interface UserService {
    User registerNewUser(SignupRequest signUpRequest) throws UserAlreadyExistAuthenticationException;

    User findUserByEmail(String email);
    Optional<User> findUserById(Long id);
    LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo);

}
