package com.finalproject.hohoho.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.finalproject.hohoho.dto.AddFavourite;
import com.finalproject.hohoho.services.AddFavouriteServiceImpl;
import com.finalproject.hohoho.services.HotelServiceImpl;

@RestController
@RequestMapping("/api")
public class AddFavouriteController {

	@Autowired
	AddFavouriteServiceImpl addFavouriteServiceImpl;
	
	@Autowired
	HotelServiceImpl hotelServiceImpl;

	// Get all addFavourites
	@PreAuthorize("hasRole('ADMIN') or hasRole('VISITOR')")
	@GetMapping("/addFavourites")
	public List<AddFavourite> list() {
		return addFavouriteServiceImpl.list();
	}
	
	// Add new favourite
	@PreAuthorize("hasRole('ADMIN') or hasRole('VISITOR')")
	@PostMapping("/addFavourite/add")
	public AddFavourite save(@RequestBody AddFavourite addFavourite) {
		return addFavouriteServiceImpl.save(addFavourite);
	}
	
	// Get favourite relation by id
	@PreAuthorize("hasRole('ADMIN') or hasRole('VISITOR')")
	@GetMapping("/addFavourite/{id}")
	public AddFavourite byId(@PathVariable(name = "id") Integer id) {
		AddFavourite addFavouriteByID = new AddFavourite();
		addFavouriteByID = addFavouriteServiceImpl.byId(id);
		return addFavouriteByID;
	}
	
	// Update favourite by id
	@PreAuthorize("hasRole('ADMIN') or hasRole('VISITOR')")
	@PutMapping("/addFavourite/update/{id}")
	public AddFavourite update(@PathVariable(name = "id") Integer id, @RequestBody AddFavourite addFavourite) {

		AddFavourite addFavouriteSelected = new AddFavourite();
		AddFavourite addFavouriteUpdated = new AddFavourite();

		addFavouriteSelected = addFavouriteServiceImpl.byId(id);
		addFavouriteSelected.setId(id);
		addFavouriteSelected.setUser(addFavourite.getUser());
		addFavouriteSelected.setHotel(addFavourite.getHotel());
		addFavouriteSelected.setStarRating(addFavourite.getStarRating());
		addFavouriteUpdated = addFavouriteServiceImpl.update(addFavouriteSelected);

		return addFavouriteUpdated;
	}
	
	// Delete favourite by id
	@PreAuthorize("hasRole('ADMIN') or hasRole('VISITOR')")
	@DeleteMapping("/addFavourite/delete/{id}")
	public void delete(@PathVariable Integer id) {
		addFavouriteServiceImpl.delete(id);
	}

}