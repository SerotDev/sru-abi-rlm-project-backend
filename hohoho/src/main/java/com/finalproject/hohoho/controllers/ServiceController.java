package com.finalproject.hohoho.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
	public List<Services> list() {
		return serviceServiceImpl.list();
	}
	
	// Add new service
	@PreAuthorize("hasRole('ADMIN') or hasRole('HOTEL')")
	@PostMapping("/service/add")
	public Services save(@RequestBody Services service) {
		return serviceServiceImpl.save(service);
	}
	
	// Get service by id
	@GetMapping("/service/{id}")
	public Services byId(@PathVariable(name = "id") Integer id) {
		Services serviceByID = new Services();
		serviceByID = serviceServiceImpl.byId(id);
		return serviceByID;
	}
	
	// Update service by id
	@PreAuthorize("hasRole('ADMIN') or hasRole('HOTEL')")
	@PutMapping("/service/update/{id}")
	public Services update(@PathVariable(name = "id") Integer id, @RequestBody Services service) {
		Services serviceSelected = new Services();
		Services serviceUpdated = new Services();

		serviceSelected = serviceServiceImpl.byId(id);
		serviceSelected.setId(id);
		serviceSelected.setName(service.getName());
		serviceUpdated = serviceServiceImpl.update(serviceSelected);

		return serviceUpdated;
	}
	
	// Delete service by id
	@PreAuthorize("hasRole('ADMIN') or hasRole('HOTEL')")
	@DeleteMapping("/service/delete/{id}")
	public void delete(@PathVariable Integer id) {
		serviceServiceImpl.delete(id);
	}
}

