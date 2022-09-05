package com.example.beclothesshop.common.utils;


import com.example.beclothesshop.common.enums.SocialProvider;
import com.example.beclothesshop.model.dto.LocalUser;
import com.example.beclothesshop.model.dto.UserInfo;
import com.example.beclothesshop.model.entity.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.example.beclothesshop.model.entity.User;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GeneralUtils {

	public static List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities(final Set<Role> roles) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName().name()));
		}
		return authorities;
	}

	public static SocialProvider toSocialProvider(String providerId) {
		for (SocialProvider socialProvider : SocialProvider.values()) {
			if (socialProvider.getProviderType().equals(providerId)) {
				return socialProvider;
			}
		}
		return SocialProvider.LOCAL;
	}

	public static UserInfo buildUserInfo(LocalUser localUser) {
		List<String> roles = localUser.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
		User user = localUser.getUser();
		System.out.println(localUser.getUser().getEmail());
		System.out.println(user.getEmail());
		return new UserInfo(String.valueOf(user.getId()), user.getName(), user.getEmail(), roles);
	}

}
