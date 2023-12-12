package com.finalproject.hohoho.services;

import java.util.List;

import com.finalproject.hohoho.dto.Event;
import com.finalproject.hohoho.dto.Hotel;
import com.finalproject.hohoho.dto.Town;

public interface IEventService {
	// CRUD models
	public List<Event> list(); // List All
	
	public List<Event> privateEventByIdHotel (Hotel hotel);
	
	public List<Event> publicEventByIdTown(Town town);

	public Event save(Event event); // (CREATE)

	public Event byId(int id); // (READ)

	public Event update(Event event); // (UPDATE)

	public void delete(int id);// (DELETE)
}
