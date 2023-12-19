package com.finalproject.hohoho.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.finalproject.hohoho.dto.Town;
import com.finalproject.hohoho.services.TownServiceImpl;

@RestController
@RequestMapping("/api")
public class TownController {

	@Autowired
	TownServiceImpl townServiceImpl;

	// Get all towns
	@GetMapping("/towns")
	public List<Town> list() {
		return townServiceImpl.list();
	}
	
	// Add new town
	@PostMapping("/town/add")
	public Town save(@RequestBody Town town) {
		return townServiceImpl.save(town);
	}
	
	// Get town by id
	@GetMapping("/town/{id}")
	public Town byId(@PathVariable(name = "id") Integer id) {
		Town townByID = new Town();
		townByID = townServiceImpl.byId(id);
		return townByID;
	}
	
	// Update town by id
	@PutMapping("/town/update/{id}")
	public Town update(@PathVariable(name = "id") Integer id, @RequestBody Town town) {

		Town townSelected = new Town();
		Town townUpdated = new Town();

		townSelected = townServiceImpl.byId(id);
		townSelected.setId(id);
		townSelected.setName(town.getName());
		townSelected.setPostalCode(town.getPostalCode());
		townSelected.setLatitude(town.getLatitude());
		townSelected.setLongitude(town.getLongitude());
		townUpdated = townServiceImpl.update(townSelected);

		return townUpdated;
	}
	
	// Delete town by id
	@DeleteMapping("/town/delete/{id}")
	public void delete(@PathVariable Integer id) {
		townServiceImpl.delete(id);
	}
}