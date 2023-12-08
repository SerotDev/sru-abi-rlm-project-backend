package com.finalproject.hohoho.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.finalproject.hohoho.dto.Hotel;

public interface IHotelService {
	// CRUD models
	public List<Hotel> list(); // List All
	
	public Page<Hotel> getPaginatedHotels(Pageable pageable); // List all hotels paginated

	public Hotel save(Hotel hotel); // (CREATE)

	public Hotel byId(int id); // (READ)

	public Hotel update(Hotel hotel); // (UPDATE)

	public void delete(int id);// (DELETE)
}
