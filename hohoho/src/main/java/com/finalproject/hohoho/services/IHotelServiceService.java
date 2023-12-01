package com.finalproject.hohoho.services;

import java.util.List;

import com.finalproject.hohoho.dto.HotelService;

public interface IHotelServiceService {
	// CRUD models
	public List<HotelService> list(); // List All

	public HotelService save(HotelService hotelService); // (CREATE)

	public HotelService byId(int id); // (READ)

	public HotelService update(HotelService hotelService); // (UPDATE)

	public void delete(int id);// (DELETE)
}
