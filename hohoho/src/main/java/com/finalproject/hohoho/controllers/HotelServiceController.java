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
	public List<HotelService> listar() {
		return hotelServiceServiceImpl.listar();
	}
	
	// Add new hotelService
	@PostMapping("/hotelService/add")
	public HotelService guardar(@RequestBody HotelService hotelService) {
		return hotelServiceServiceImpl.guardar(hotelService);
	}
	
	// Get hotelService by id
	@GetMapping("/hotelService/{id}")
	public HotelService porIdentificador(@PathVariable(name = "id") Integer id) {
		HotelService hotelServiceByID = new HotelService();
		hotelServiceByID = hotelServiceServiceImpl.porIdentificador(id);
		return hotelServiceByID;
	}
	
	// Update hotelService by id
	@PutMapping("/hotelService/update/{id}")
	public HotelService actualizar(@PathVariable(name = "id") Integer id, @RequestBody HotelService hotelService) {

		HotelService hotelServiceSelected = new HotelService();
		HotelService hotelServiceUpdated = new HotelService();

		hotelServiceSelected = hotelServiceServiceImpl.porIdentificador(id);
		hotelServiceSelected.setId(id);
		hotelServiceSelected.setHotel(hotelService.getHotel());
		hotelServiceSelected.setService(hotelService.getService());
		hotelServiceUpdated = hotelServiceServiceImpl.actualizar(hotelServiceSelected);

		return hotelServiceUpdated;
	}
	
	// Delete hotelService by id
	@DeleteMapping("/hotelService/delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		hotelServiceServiceImpl.eliminar(id);
	}
}

