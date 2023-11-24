package com.finalproject.hohoho.services;

import java.util.List;

import com.finalproject.hohoho.dto.Town;

public interface ITownService {
	// CRUD models
	public List<Town> listar(); // List All

	public Town guardar(Town town); // (CREATE)

	public Town porIdentificador(int id); // (READ)

	public Town actualizar(Town town); // (UPDATE)

	public void eliminar(int id);// (DELETE)
}
