package com.egg.inmoDocHouse.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JWTAuthResponse {

	private String accessToken;
	private String username;
	private String tokenType = "Bearer";

	public JWTAuthResponse(String accessToken , String username) {
		this.accessToken = accessToken;
		this.username = username;

	}
}
