package com.finalproject.hohoho.services;

import java.util.List;

import com.finalproject.hohoho.dto.Role;

public interface IRoleService {
	// CRUD models
	public List<Role> list(); // List All

	public Role save(Role role); // (CREATE)

	public Role byId(int id); // (READ)

	public Role update(Role role); // (UPDATE)

	public void delete(int id);// (DELETE)
}
