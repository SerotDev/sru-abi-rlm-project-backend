package com.finalproject.hohoho.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.finalproject.hohoho.dto.HotelService;
import com.finalproject.hohoho.services.HotelServiceServiceImpl;

@RestController
@RequestMapping("/api")
public class HotelServiceController {

	@Autowired
	HotelServiceServiceImpl hotelServiceServiceImpl;

	// Get all hotelServices
	@GetMapping("/hotelServices")
	public List<HotelService> list() {
		return hotelServiceServiceImpl.list();
	}
	
	// Add new hotelService
	@PostMapping("/hotelService/add")
	public HotelService save(@RequestBody HotelService hotelService) {
		return hotelServiceServiceImpl.save(hotelService);
	}
	
	// Get hotelService by id
	@GetMapping("/hotelService/{id}")
	public HotelService byId(@PathVariable(name = "id") Integer id) {
		HotelService hotelServiceByID = new HotelService();
		hotelServiceByID = hotelServiceServiceImpl.byId(id);
		return hotelServiceByID;
	}
	
	// Update hotelService by id
	@PutMapping("/hotelService/update/{id}")
	public HotelService update(@PathVariable(name = "id") Integer id, @RequestBody HotelService hotelService) {

		HotelService hotelServiceSelected = new HotelService();
		HotelService hotelServiceUpdated = new HotelService();

		hotelServiceSelected = hotelServiceServiceImpl.byId(id);
		hotelServiceSelected.setId(id);
		hotelServiceSelected.setHotel(hotelService.getHotel());
		hotelServiceSelected.setService(hotelService.getService());
		hotelServiceUpdated = hotelServiceServiceImpl.update(hotelServiceSelected);

		return hotelServiceUpdated;
	}
	
	// Delete hotelService by id
	@DeleteMapping("/hotelService/delete/{id}")
	public void delete(@PathVariable Integer id) {
		hotelServiceServiceImpl.delete(id);
	}
}

