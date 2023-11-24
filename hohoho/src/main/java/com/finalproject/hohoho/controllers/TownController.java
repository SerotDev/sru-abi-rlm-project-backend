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

	@GetMapping("/towns")
	public List<Town> listar() {
		return townServiceImpl.listar();
	}

	@GetMapping("/town/{id}")
	public Town porIdentificador(@PathVariable(name = "id") Integer id) {
		return townServiceImpl.porIdentificador(id);
	}

	@PostMapping("/town/add")
	public Town guardar(@RequestBody Town town) {
		return townServiceImpl.guardar(town);
	}

	@PutMapping("/town/update/{id}")
	public Town actualizar(@PathVariable(name = "id") Integer id, @RequestBody Town town) {

		Town town_selected = new Town();
		Town town_updated = new Town();

		town_selected = townServiceImpl.porIdentificador(id);
		town_selected.setId(id);
		town_selected.setName(town.getName());
		town_selected.setPostal_code(town.getPostal_code());
		town_selected.setLatitude(town.getLatitude());
		town_selected.setLongitude(town.getLongitude());
		
		town_updated = townServiceImpl.actualizar(town_selected);

		return town_updated;
	}

	@DeleteMapping("/town/delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		townServiceImpl.eliminar(id);
	}
}

