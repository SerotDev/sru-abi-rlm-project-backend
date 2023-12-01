package com.finalproject.hohoho.services;

import java.util.List;

import com.finalproject.hohoho.dto.Services;

public interface IServicesService {
	// CRUD models
	public List<Services> list(); // List All

	public Services save(Services service); // (CREATE)

	public Services byId(int id); // (READ)

	public Services update(Services service); // (UPDATE)

	public void delete(int id);// (DELETE)
}
