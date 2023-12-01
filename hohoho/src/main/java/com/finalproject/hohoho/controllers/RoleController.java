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
	public List<Role> list() {
		return roleServiceImpl.list();
	}
	
	// Add new role
	@PostMapping("/role/add")
	public Role save(@RequestBody Role role) {
		return roleServiceImpl.save(role);
	}
	
	// Get role by id
	@GetMapping("/role/{id}")
	public Role byId(@PathVariable(name = "id") Integer id) {
		Role roleByID = new Role();
		roleByID = roleServiceImpl.byId(id);
		return roleByID;
	}
	
	// Update role by id
	@PutMapping("/role/update/{id}")
	public Role update(@PathVariable(name = "id") Integer id, @RequestBody Role role) {

		Role roleSelected = new Role();
		Role roleUpdated = new Role();

		roleSelected = roleServiceImpl.byId(id);
		roleSelected.setId(id);
		roleSelected.setName(role.getName());
		roleUpdated = roleServiceImpl.update(roleSelected);

		return roleUpdated;
	}
	
	// Delete role by id
	@DeleteMapping("/role/delete/{id}")
	public void delete(@PathVariable Integer id) {
		roleServiceImpl.delete(id);
	}
}

