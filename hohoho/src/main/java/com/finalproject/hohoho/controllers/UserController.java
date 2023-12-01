package com.finalproject.hohoho.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.finalproject.hohoho.dto.User;
import com.finalproject.hohoho.services.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	// Get all users
	@GetMapping("/users")
	public List<User> listar() {
		return userServiceImpl.listar();
	}
	
	// Add new user
	@PostMapping("/user/add")
	public User guardar(@RequestBody User user) {
		return userServiceImpl.guardar(user);
	}
	
	// Get user by id
	@GetMapping("/user/{id}")
	public User porIdentificador(@PathVariable(name = "id") Integer id) {
		User userByID = new User();
		userByID = userServiceImpl.porIdentificador(id);
		return userByID;
	}
	
	// Update user by id
	@PutMapping("/user/update/{id}")
	public User actualizar(@PathVariable(name = "id") Integer id, @RequestBody User user) {

		User userSelected = new User();
		User userUpdated = new User();

		userSelected = userServiceImpl.porIdentificador(id);
		userSelected.setId(id);
		userSelected.setName(user.getName());
		userSelected.setSurname(user.getSurname());
		userSelected.setPhone(user.getPhone());
		userSelected.setProf_img_url(user.getProf_img_url());
		userSelected.setEmail(user.getEmail());
		userSelected.setPassword(user.getPassword());
		userSelected.setRegistration_date(user.getRegistration_date());
		userSelected.setRole(user.getRole());
		userUpdated = userServiceImpl.actualizar(userSelected);

		return userUpdated;
	}
	
	// Delete user by id
	@DeleteMapping("/user/delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		userServiceImpl.eliminar(id);
	}
}

