package com.finalproject.hohoho.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.finalproject.hohoho.dto.Hotel;
import com.finalproject.hohoho.services.HotelServiceImpl;

@RestController
@RequestMapping("/api")
public class HotelController {

	@Autowired
	HotelServiceImpl hotelServiceImpl;

	// Get all hotels
	@GetMapping("/hotels")
	public List<Hotel> listar() {
		return hotelServiceImpl.listar();
	}
	
	// Add new hotel
	@PostMapping("/hotel/add")
	public Hotel guardar(@RequestBody Hotel hotel) {
		return hotelServiceImpl.guardar(hotel);
	}
	
	// Get hotel by id
	@GetMapping("/hotel/{id}")
	public Hotel porIdentificador(@PathVariable(name = "id") Integer id) {
		Hotel hotelByID = new Hotel();
		hotelByID = hotelServiceImpl.porIdentificador(id);
		return hotelByID;
	}
	
	// Update hotel by id
	@PutMapping("/hotel/update/{id}")
	public Hotel actualizar(@PathVariable(name = "id") Integer id, @RequestBody Hotel hotel) {

		Hotel hotelSelected = new Hotel();
		Hotel hotelUpdated = new Hotel();

		hotelSelected = hotelServiceImpl.porIdentificador(id);
		hotelSelected.setId(id);
		hotelSelected.setDescription(hotel.getDescription());
		hotelSelected.setPhone(hotel.getPhone());
		hotelSelected.setAddress(hotel.getAddress());
		hotelSelected.setEmail(hotel.getEmail());
		hotelSelected.setWeb(hotel.getWeb());
		hotelSelected.setNumber_rooms(hotel.getNumber_rooms());
		hotelSelected.setImgs_url(hotel.getImgs_url());
		hotelSelected.setPrice(hotel.getPrice());
		hotelSelected.setLatitude(hotel.getLatitude());
		hotelSelected.setLongitude(hotel.getLongitude());
		hotelSelected.setUser(hotel.getUser());
		hotelSelected.setTown(hotel.getTown());
		hotelUpdated = hotelServiceImpl.actualizar(hotelSelected);

		return hotelUpdated;
	}
	
	// Delete hotel by id
	@DeleteMapping("/hotel/delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		hotelServiceImpl.eliminar(id);
	}
}
