package com.finalproject.hohoho.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.hohoho.dto.Event;
import com.finalproject.hohoho.dto.Hotel;
import com.finalproject.hohoho.dto.Town;
import com.finalproject.hohoho.services.EventServiceImpl;
import com.finalproject.hohoho.services.HotelServiceImpl;
import com.finalproject.hohoho.services.TownServiceImpl;

@RestController
@RequestMapping("/api")
public class EventController {

	@Autowired
	EventServiceImpl eventServiceImpl;
	@Autowired
	HotelServiceImpl hotelServiceImpl;
	@Autowired
	TownServiceImpl townServiceImpl;

	// Get all events
	@PostMapping("/events")
	public List<Event> list() {
		return eventServiceImpl.list();
	}
	
	// Add new event
	@PostMapping("/event/add")
	public Event save(@RequestBody Event event) {
		return eventServiceImpl.save(event);
	}
	
	//Get event private by id Hotel
	@GetMapping("/events-private/{idHotel}")
	public List<Event> privateEventByIdHotel(@PathVariable(name = "idHotel")Integer idHotel){
		Hotel hotel = hotelServiceImpl.byId(idHotel);
		return eventServiceImpl.privateEventByIdHotel(hotel);
	}
	//Get event public by id Town
	@GetMapping("/events-public/{idTown}")
	public List<Event> publicEventByIdTown(@PathVariable(name = "idTown")Integer idTown){
		Town town = townServiceImpl.byId(idTown);
		Pageable wholePages = Pageable.unpaged();
		Page <Hotel> pageHotels = hotelServiceImpl.listPageHotelsByTown(wholePages, town);
		List<Hotel> hotels = pageHotels.getContent();
		// Declaration of public events by town
		List<Event> events = new ArrayList <Event>();
		for (int i = 0; i < hotels.size(); i++) {
			List <Event> hotelPublicEvents = eventServiceImpl.publicEventByIdTown(hotels.get(i));
			for (int j = 0; j < hotelPublicEvents.size(); j++) {
				events.add(hotelPublicEvents.get(j));
			}
		}
		return events;
	}
	
	// Get event by id
	@GetMapping("/event/{id}")
	public Event byId(@PathVariable(name = "id") Integer id) {
		Event eventByID = new Event();
		eventByID = eventServiceImpl.byId(id);
		return eventByID;
	}
	
	// Update event by id
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
	@DeleteMapping("/event/delete/{id}")
	public void delete(@PathVariable Integer id) {
		eventServiceImpl.delete(id);
	}
}

