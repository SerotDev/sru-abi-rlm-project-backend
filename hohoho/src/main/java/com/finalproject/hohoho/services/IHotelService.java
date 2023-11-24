package com.finalproject.hohoho.services;

import java.util.List;

import com.finalproject.hohoho.dto.Hotel;

public interface IHotelService {
	// CRUD models
	public List<Hotel> listar(); // List All

	public Hotel guardar(Hotel hotel); // (CREATE)

	public Hotel porIdentificador(int id); // (READ)

	public Hotel actualizar(Hotel hotel); // (UPDATE)

	public void eliminar(int id);// (DELETE)
}
