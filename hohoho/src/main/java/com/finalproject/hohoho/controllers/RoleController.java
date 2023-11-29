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

	@GetMapping("/roles")
	public List<Role> listar() {
		return roleServiceImpl.listar();
	}

	@GetMapping("/role/{id}")
	public Role porIdentificador(@PathVariable(name = "id") Integer id) {
		return roleServiceImpl.porIdentificador(id);
	}

	@PostMapping("/role/add")
	public Role guardar(@RequestBody Role role) {
		return roleServiceImpl.guardar(role);
	}

	@PutMapping("/role/update/{id}")
	public Role actualizar(@PathVariable(name = "id") Integer id, @RequestBody Role role) {

		Role role_selected = new Role();
		Role role_updated = new Role();

		role_selected = roleServiceImpl.porIdentificador(id);
		role_selected.setId(id);
		role_selected.setName(role.getName());
		role_updated = roleServiceImpl.actualizar(role_selected);

		return role_updated;
	}

	@DeleteMapping("/role/delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		roleServiceImpl.eliminar(id);
	}
}

