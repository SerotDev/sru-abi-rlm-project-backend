package com.finalproject.hohoho.jwt;

import lombok.Data;

/**
 * @author Jose Marin
 */

@Data
public class JWTAuthenticationRequest {
    private String username;
    private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
}