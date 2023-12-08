package com.finalproject.hohoho.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.finalproject.hohoho.dto.Hotel;
import com.finalproject.hohoho.dto.Town;
import com.finalproject.hohoho.services.HotelServiceImpl;
import org.springframework.data.domain.Pageable;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api")
public class HotelController {

	@Autowired
	HotelServiceImpl hotelServiceImpl;

	@GetMapping("/pageable")
	public ResponseEntity<Map<String, Object>> pageAllHotels(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Hotel> hotelPage = hotelServiceImpl.getPaginatedHotels(pageable);
		Map<String, Object> response = new HashMap<>();
		response.put("currentPage", hotelPage.getNumber());
		response.put("totalItems", hotelPage.getTotalElements());
		response.put("totalPages", hotelPage.getTotalPages());
		response.put("Hotels", hotelPage.getContent());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// Add new hotel
	@PostMapping("/hotel/add")
	public Hotel save(@RequestBody Hotel hotel) {
		return hotelServiceImpl.save(hotel);
	}

	// Get hotel by id
	@GetMapping("/hotel/{id}")
	public Hotel byId(@PathVariable(name = "id") Integer id) {
		Hotel hotelByID = new Hotel();
		hotelByID = hotelServiceImpl.byId(id);
		return hotelByID;
	}

	// Update hotel by id
	@PutMapping("/hotel/update/{id}")
	public Hotel update(@PathVariable(name = "id") Integer id, @RequestBody Hotel hotel) {

		Hotel hotelSelected = new Hotel();
		Hotel hotelUpdated = new Hotel();

		hotelSelected = hotelServiceImpl.byId(id);
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
		hotelUpdated = hotelServiceImpl.update(hotelSelected);

		return hotelUpdated;
	}

	// Delete hotel by id
	@DeleteMapping("/hotel/delete/{id}")
	public void delete(@PathVariable Integer id) {
		hotelServiceImpl.delete(id);
	}
}
