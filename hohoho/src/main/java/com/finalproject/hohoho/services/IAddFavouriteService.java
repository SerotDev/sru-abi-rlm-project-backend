package com.finalproject.hohoho.services;

import java.util.List;

import com.finalproject.hohoho.dto.AddFavourite;

public interface IAddFavouriteService {
	//CRUD models
	public List<AddFavourite> list(); // List All

	public AddFavourite save(AddFavourite addFavourite); // (CREATE)

	public AddFavourite byId(int id); // (READ)

	public AddFavourite update(AddFavourite addFavourite); // (UPDATE)

	public void delete(int id);// (DELETE)
}
