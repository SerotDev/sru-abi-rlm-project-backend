package com.finalproject.hohoho.services;

import java.util.List;

import com.finalproject.hohoho.dto.User;

public interface IUserService {
	// CRUD models
	public List<User> list(); // List All
	
	public User save(User user); // (CREATE)

	public User byId(int id); // (READ)

	public User update(User user); // (UPDATE)

	public void delete(int id);// (DELETE)
}
