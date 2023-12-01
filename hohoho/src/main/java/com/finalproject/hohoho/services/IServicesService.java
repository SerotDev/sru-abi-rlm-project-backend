package com.finalproject.hohoho.services;

import java.util.List;

import com.finalproject.hohoho.dto.Services;

public interface IServicesService {
	// CRUD models
	public List<Services> listar(); // List All

	public Services guardar(Services service); // (CREATE)

	public Services porIdentificador(int id); // (READ)

	public Services actualizar(Services service); // (UPDATE)

	public void eliminar(int id);// (DELETE)
}
