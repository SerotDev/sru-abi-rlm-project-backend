package com.finalproject.hohoho.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.finalproject.hohoho.dto.Event;
import com.finalproject.hohoho.services.EventServiceImpl;

@RestController
@RequestMapping("/api")
public class EventController {

	@Autowired
	EventServiceImpl eventServiceImpl;

	// Get all events
	@GetMapping("/events")
	public List<Event> listar() {
		return eventServiceImpl.listar();
	}
	
	// Add new event
	@PostMapping("/event/add")
	public Event guardar(@RequestBody Event event) {
		return eventServiceImpl.guardar(event);
	}
	
	// Get event by id
	@GetMapping("/event/{id}")
	public Event porIdentificador(@PathVariable(name = "id") Integer id) {
		Event eventByID = new Event();
		eventByID = eventServiceImpl.porIdentificador(id);
		return eventByID;
	}
	
	// Update event by id
	@PutMapping("/event/update/{id}")
	public Event actualizar(@PathVariable(name = "id") Integer id, @RequestBody Event event) {

		Event eventSelected = new Event();
		Event eventUpdated = new Event();

		eventSelected = eventServiceImpl.porIdentificador(id);
		eventSelected.setId(id);
		eventSelected.setTitle(event.getTitle());
		eventSelected.setDescription(event.getDescription());
		eventSelected.setImg_url(event.getImg_url());
		eventSelected.setStart_date(event.getStart_date());
		eventSelected.setEntry_price(event.getEntry_price());
		eventSelected.setIs_public(event.getIs_public());
		eventSelected.setLatitude(event.getLatitude());
		eventSelected.setLongitude(event.getLongitude());
		eventSelected.setHotel(event.getHotel());
		eventUpdated = eventServiceImpl.actualizar(eventSelected);

		return eventUpdated;
	}
	
	// Delete event by id
	@DeleteMapping("/event/delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		eventServiceImpl.eliminar(id);
	}
}

