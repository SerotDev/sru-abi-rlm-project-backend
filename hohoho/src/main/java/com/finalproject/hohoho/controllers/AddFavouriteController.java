package com.finalproject.hohoho.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.finalproject.hohoho.dto.AddFavourite;
import com.finalproject.hohoho.services.AddFavouriteServiceImpl;

@RestController
@RequestMapping("/api")
public class AddFavouriteController {

	@Autowired
	AddFavouriteServiceImpl addFavouriteServiceImpl;

	// Get all addFavourites
	@GetMapping("/addFavourites")
	public List<AddFavourite> listar() {
		return addFavouriteServiceImpl.listar();
	}
	
	// Add new favourite
	@PostMapping("/addFavourite/add")
	public AddFavourite guardar(@RequestBody AddFavourite addFavourite) {
		return addFavouriteServiceImpl.guardar(addFavourite);
	}
	
	// Get favourite relation by id
	@GetMapping("/addFavourite/{id}")
	public AddFavourite porIdentificador(@PathVariable(name = "id") Integer id) {
		AddFavourite addFavouriteByID = new AddFavourite();
		addFavouriteByID = addFavouriteServiceImpl.porIdentificador(id);
		return addFavouriteByID;
	}
	
	// Update favourite by id
	@PutMapping("/addFavourite/update/{id}")
	public AddFavourite actualizar(@PathVariable(name = "id") Integer id, @RequestBody AddFavourite addFavourite) {

		AddFavourite addFavouriteSelected = new AddFavourite();
		AddFavourite addFavouriteUpdated = new AddFavourite();

		addFavouriteSelected = addFavouriteServiceImpl.porIdentificador(id);
		addFavouriteSelected.setId(id);
		addFavouriteSelected.setUser(addFavourite.getUser());
		addFavouriteSelected.setHotel(addFavourite.getHotel());
		addFavouriteUpdated = addFavouriteServiceImpl.actualizar(addFavouriteSelected);

		return addFavouriteUpdated;
	}
	
	// Delete favourite by id
	@DeleteMapping("/addFavourite/delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		addFavouriteServiceImpl.eliminar(id);
	}
}