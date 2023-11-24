package com.finalproject.hohoho.services;

import java.util.List;

import com.finalproject.hohoho.dto.HotelService;

public interface IHotelServiceService {
	// CRUD models
	public List<HotelService> listar(); // List All

	public HotelService guardar(HotelService hotelService); // (CREATE)

	public HotelService porIdentificador(int id); // (READ)

	public HotelService actualizar(HotelService hotelService); // (UPDATE)

	public void eliminar(int id);// (DELETE)
}
