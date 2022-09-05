package com.example.beclothesshop.model.dto;

import com.example.beclothesshop.model.dto.UserInfo;

public class JwtAuthenticationResponse {
	private String accessToken;
	private UserInfo user;

	public JwtAuthenticationResponse(String accessToken, UserInfo user) {
		this.accessToken = accessToken;
		this.user = user;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public JwtAuthenticationResponse() {
	}
}
