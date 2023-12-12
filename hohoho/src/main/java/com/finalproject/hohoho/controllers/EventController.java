package com.finalproject.hohoho.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.finalproject.hohoho.dto.Event;
import com.finalproject.hohoho.dto.Hotel;
import com.finalproject.hohoho.services.EventServiceImpl;
import com.finalproject.hohoho.services.HotelServiceImpl;

@RestController
@RequestMapping("/api")
public class EventController {

	@Autowired
	EventServiceImpl eventServiceImpl;
	@Autowired
	HotelServiceImpl hotelServiceImpl;

	// Get all events
	@GetMapping("/events")
	public List<Event> list() {
		return eventServiceImpl.list();
	}
	
	// Add new event
	@PreAuthorize("hasRole('ADMIN') or hasRole('HOTEL')")
	@PostMapping("/event/add")
	public Event save(@RequestBody Event event) {
		return eventServiceImpl.save(event);
	}
	//Get event private by id Hotel
	@GetMapping("/event-private/{id}")
	public List<Event> findByIsPublicFalseAndIdHotel(@PathVariable(name = "id")Integer idHotel){
		Hotel hotel = hotelServiceImpl.byId(idHotel);
		return eventServiceImpl.privateEventByIdHotel(hotel);
	}
	
	// Get event by id
	@GetMapping("/event/{id}")
	public Event byId(@PathVariable(name = "id") Integer id) {
		Event eventByID = new Event();
		eventByID = eventServiceImpl.byId(id);
		return eventByID;
	}
	
	// Update event by id
	@PreAuthorize("hasRole('ADMIN') or hasRole('HOTEL')")
	@PutMapping("/event/update/{id}")
	public Event update(@PathVariable(name = "id") Integer id, @RequestBody Event event) {

		Event eventSelected = new Event();
		Event eventUpdated = new Event();

		eventSelected = eventServiceImpl.byId(id);
		eventSelected.setId(id);
		eventSelected.setTitle(event.getTitle());
		eventSelected.setDescription(event.getDescription());
		eventSelected.setImgUrl(event.getImgUrl());
		eventSelected.setStartDate(event.getStartDate());
		eventSelected.setEntryPrice(event.getEntryPrice());
		eventSelected.setIsPublic(event.getIsPublic());
		eventSelected.setLatitude(event.getLatitude());
		eventSelected.setLongitude(event.getLongitude());
		eventSelected.setHotel(event.getHotel());
		eventUpdated = eventServiceImpl.update(eventSelected);

		return eventUpdated;
	}
	
	// Delete event by id
	@PreAuthorize("hasRole('ADMIN') or hasRole('HOTEL')")
	@DeleteMapping("/event/delete/{id}")
	public void delete(@PathVariable Integer id) {
		eventServiceImpl.delete(id);
	}
}

