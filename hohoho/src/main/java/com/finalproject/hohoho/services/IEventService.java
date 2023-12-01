package com.finalproject.hohoho.services;

import java.util.List;

import com.finalproject.hohoho.dto.Event;

public interface IEventService {
	// CRUD models
	public List<Event> list(); // List All

	public Event save(Event event); // (CREATE)

	public Event byId(int id); // (READ)

	public Event update(Event event); // (UPDATE)

	public void delete(int id);// (DELETE)
}
