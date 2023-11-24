package com.finalproject.hohoho.services;

import java.util.List;

import com.finalproject.hohoho.dto.AddFavourite;

public interface IAddFavouriteService {
	//CRUD models
	public List<AddFavourite> listar(); // List All

	public AddFavourite guardar(AddFavourite addFavourite); // (CREATE)

	public AddFavourite porIdentificador(int id); // (READ)

	public AddFavourite actualizar(AddFavourite addFavourite); // (UPDATE)

	public void eliminar(int id);// (DELETE)
}
