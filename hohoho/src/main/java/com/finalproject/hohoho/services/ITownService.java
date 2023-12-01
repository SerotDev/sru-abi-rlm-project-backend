package com.finalproject.hohoho.services;

import java.util.List;

import com.finalproject.hohoho.dto.Town;

public interface ITownService {
	// CRUD models
	public List<Town> list(); // List All

	public Town save(Town town); // (CREATE)

	public Town byId(int id); // (READ)

	public Town update(Town town); // (UPDATE)

	public void delete(int id);// (DELETE)
}
