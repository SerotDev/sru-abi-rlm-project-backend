package com.finalproject.hohoho.dto;

import java.time.LocalDateTime;

public class UserDTO {

	private Long id;
	private String email;
	private String username;
	private Role role;
    private LocalDateTime registrationDate;

	private UserDTO(Builder builder) {
		this.id = builder.id;
		this.email = builder.email;
		this.username = builder.username;
		this.role = builder.role;
		this.registrationDate = builder.registration_date;
	}
	
	public LocalDateTime getRegistration_date() {
		return registrationDate;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public Role getRole() {
		return role;
	}

	public static class Builder {
		private Long id;
		private String email;
		private String username;
		private Role role;
		private LocalDateTime registration_date;

		public Builder() {
		}
		
		public Builder setRegistration_date(LocalDateTime registrationDate) {
			this.registration_date = registrationDate;
			return this;
		}
		
		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder setUsername(String username) {
			this.username = username;
			return this;
		}

		public Builder setRole(Role role) {
			this.role = role;
			return this;
		}

		public UserDTO build() {
			return new UserDTO(this);
		}
	}







}