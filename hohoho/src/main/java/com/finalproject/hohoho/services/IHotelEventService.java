package com.finalproject.hohoho.services;

import java.util.List;

import com.finalproject.hohoho.dto.HotelEvent;

public interface IHotelEventService {
	// CRUD models
	public List<HotelEvent> listar(); // List All

	public HotelEvent guardar(HotelEvent hotelEvent); // (CREATE)

	public HotelEvent porIdentificador(int id); // (READ)

	public HotelEvent actualizar(HotelEvent hotelEvent); // (UPDATE)

	public void eliminar(int id);// (DELETE)
}
