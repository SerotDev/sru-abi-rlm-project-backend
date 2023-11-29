package com.finalproject.hohoho.services;

import java.util.List;

import com.finalproject.hohoho.dto.Role;

public interface IRoleService {
	// CRUD models
	public List<Role> listar(); // List All

	public Role guardar(Role role); // (CREATE)

	public Role porIdentificador(int id); // (READ)

	public Role actualizar(Role role); // (UPDATE)

	public void eliminar(int id);// (DELETE)
}
