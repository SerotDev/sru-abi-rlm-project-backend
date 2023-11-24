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

	@GetMapping("/add_favourites")
	public List<AddFavourite> listar() {
		return addFavouriteServiceImpl.listar();
	}

	@GetMapping("/add_favourite/{id}")
	public AddFavourite porIdentificador(@PathVariable(name = "id") Integer id) {
		return addFavouriteServiceImpl.porIdentificador(id);
	}

	@PostMapping("/add_favourite/add")
	public AddFavourite guardar(@RequestBody AddFavourite addFavourite) {
		return addFavouriteServiceImpl.guardar(addFavourite);
	}

	@PutMapping("/add_favourite/update/{id}")
	public AddFavourite actualizar(@PathVariable(name = "id") Integer id, @RequestBody AddFavourite addFavourite) {

		AddFavourite add_favourite_selected = new AddFavourite();
		AddFavourite add_favourite_updated = new AddFavourite();

		add_favourite_selected = addFavouriteServiceImpl.porIdentificador(id);
		add_favourite_selected.setId(id);
		add_favourite_selected.setHotel(addFavourite.getHotel());
		add_favourite_selected.setUser(addFavourite.getUser());
		add_favourite_selected.setStar_rating(addFavourite.getStar_rating());
		add_favourite_updated = addFavouriteServiceImpl.actualizar(add_favourite_selected);

		return add_favourite_updated;
	}

	@DeleteMapping("/add_favourite/delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		addFavouriteServiceImpl.eliminar(id);
	}
}

