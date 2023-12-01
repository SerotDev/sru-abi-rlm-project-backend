package com.finalproject.hohoho.services;

import java.util.List;

import com.finalproject.hohoho.dto.Hotel;

public interface IHotelService {
	// CRUD models
	public List<Hotel> list(); // List All

	public Hotel save(Hotel hotel); // (CREATE)

	public Hotel byId(int id); // (READ)

	public Hotel update(Hotel hotel); // (UPDATE)

	public void delete(int id);// (DELETE)
}
