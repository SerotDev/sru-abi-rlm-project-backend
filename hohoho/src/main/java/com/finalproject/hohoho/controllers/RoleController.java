package com.finalproject.hohoho.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.finalproject.hohoho.dto.Role;
import com.finalproject.hohoho.services.RoleServiceImpl;

@RestController
@RequestMapping("/api")
public class RoleController {

	@Autowired
	RoleServiceImpl roleServiceImpl;

	// Get all roles
	@GetMapping("/roles")
	public List<Role> listar() {
		return roleServiceImpl.listar();
	}
	
	// Add new role
	@PostMapping("/role/add")
	public Role guardar(@RequestBody Role role) {
		return roleServiceImpl.guardar(role);
	}
	
	// Get role by id
	@GetMapping("/role/{id}")
	public Role porIdentificador(@PathVariable(name = "id") Integer id) {
		Role roleByID = new Role();
		roleByID = roleServiceImpl.porIdentificador(id);
		return roleByID;
	}
	
	// Update role by id
	@PutMapping("/role/update/{id}")
	public Role actualizar(@PathVariable(name = "id") Integer id, @RequestBody Role role) {

		Role roleSelected = new Role();
		Role roleUpdated = new Role();

		roleSelected = roleServiceImpl.porIdentificador(id);
		roleSelected.setId(id);
		roleSelected.setName(role.getName());
		roleUpdated = roleServiceImpl.actualizar(roleSelected);

		return roleUpdated;
	}
	
	// Delete role by id
	@DeleteMapping("/role/delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		roleServiceImpl.eliminar(id);
	}
}

