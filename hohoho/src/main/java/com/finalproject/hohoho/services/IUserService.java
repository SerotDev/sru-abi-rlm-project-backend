package com.finalproject.hohoho.services;

import java.util.List;

import com.finalproject.hohoho.dto.User;

public interface IUserService {
	// CRUD models
	public List<User> listar(); // List All

	public User guardar(User user); // (CREATE)

	public User porIdentificador(int id); // (READ)

	public User actualizar(User user); // (UPDATE)

	public void eliminar(int id);// (DELETE)
}
