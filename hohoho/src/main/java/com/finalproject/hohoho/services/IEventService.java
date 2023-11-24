package com.finalproject.hohoho.services;

import java.util.List;

import com.finalproject.hohoho.dto.Event;

public interface IEventService {
	// CRUD models
	public List<Event> listar(); // List All

	public Event guardar(Event event); // (CREATE)

	public Event porIdentificador(int id); // (READ)

	public Event actualizar(Event event); // (UPDATE)

	public void eliminar(int id);// (DELETE)
}
