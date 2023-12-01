package com.finalproject.hohoho.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.finalproject.hohoho.dto.Services;
import com.finalproject.hohoho.services.ServicesServiceImpl;

@RestController
@RequestMapping("/api")
public class ServiceController {

	@Autowired
	ServicesServiceImpl serviceServiceImpl;

	// Get all services
	@GetMapping("/services")
	public List<Services> listar() {
		return serviceServiceImpl.listar();
	}
	
	// Add new service
	@PostMapping("/service/add")
	public Services guardar(@RequestBody Services service) {
		return serviceServiceImpl.guardar(service);
	}
	
	// Get service by id
	@GetMapping("/service/{id}")
	public Services porIdentificador(@PathVariable(name = "id") Integer id) {
		Services serviceByID = new Services();
		serviceByID = serviceServiceImpl.porIdentificador(id);
		return serviceByID;
	}
	
	// Update service by id
	@PutMapping("/service/update/{id}")
	public Services actualizar(@PathVariable(name = "id") Integer id, @RequestBody Services service) {
		Services serviceSelected = new Services();
		Services serviceUpdated = new Services();

		serviceSelected = serviceServiceImpl.porIdentificador(id);
		serviceSelected.setId(id);
		serviceSelected.setName(service.getName());
		serviceUpdated = serviceServiceImpl.actualizar(serviceSelected);

		return serviceUpdated;
	}
	
	// Delete service by id
	@DeleteMapping("/service/delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		serviceServiceImpl.eliminar(id);
	}
}

