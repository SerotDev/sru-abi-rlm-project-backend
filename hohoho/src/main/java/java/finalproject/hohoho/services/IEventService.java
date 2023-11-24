package java.finalproject.hohoho.services;

import java.finalproject.hohoho.dto.Event;
import java.util.List;

public interface IEventService {
	// CRUD models
	public List<Event> listar(); // List All

	public Event guardar(Event event); // (CREATE)

	public Event porIdentificador(int id); // (READ)

	public Event actualizar(Event event); // (UPDATE)

	public void eliminar(int id);// (DELETE)
}
