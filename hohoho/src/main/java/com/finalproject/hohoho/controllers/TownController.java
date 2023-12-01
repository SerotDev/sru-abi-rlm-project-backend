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
	public List<Town> listar() {
		return townServiceImpl.listar();
	}
	
	// Add new town
	@PostMapping("/town/add")
	public Town guardar(@RequestBody Town town) {
		return townServiceImpl.guardar(town);
	}
	
	// Get town by id
	@GetMapping("/town/{id}")
	public Town porIdentificador(@PathVariable(name = "id") Integer id) {
		Town townByID = new Town();
		townByID = townServiceImpl.porIdentificador(id);
		return townByID;
	}
	
	// Update town by id
	@PutMapping("/town/update/{id}")
	public Town actualizar(@PathVariable(name = "id") Integer id, @RequestBody Town town) {

		Town townSelected = new Town();
		Town townUpdated = new Town();

		townSelected = townServiceImpl.porIdentificador(id);
		townSelected.setId(id);
		townSelected.setName(town.getName());
		townUpdated = townServiceImpl.actualizar(townSelected);

		return townUpdated;
	}
	
	// Delete town by id
	@DeleteMapping("/town/delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		townServiceImpl.eliminar(id);
	}
}