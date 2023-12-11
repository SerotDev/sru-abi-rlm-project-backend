package com.finalproject.hohoho.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.finalproject.hohoho.dto.User;
import com.finalproject.hohoho.services.HotelServiceImpl;
import com.finalproject.hohoho.services.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	HotelServiceImpl hotelServiceImpl;

	// Get all users
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/users")
	public List<User> list() {
		return userServiceImpl.list();
	}
	
	// Add new user
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/user/add")
	public User save(@RequestBody User user) {
		return userServiceImpl.save(user);
	}
	
	// Get user by id
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/user/{id}")
	public User byId(@PathVariable(name = "id") Integer id) {
		User userByID = new User();
		userByID = userServiceImpl.byId(id);
		return userByID;
	}
	
	// Update user by id
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/user/update/{id}")
	public User update(@PathVariable(name = "id") Integer id, @RequestBody User user) {

		User userSelected = new User();
		User userUpdated = new User();

		userSelected = userServiceImpl.byId(id);
		userSelected.setId(id);
		userSelected.setName(user.getName());
		userSelected.setSurname(user.getSurname());
		userSelected.setPhone(user.getPhone());
		userSelected.setProf_img_url(user.getProf_img_url());
		userSelected.setEmail(user.getEmail());
		userSelected.setPassword(user.getPassword());
		userSelected.setRegistration_date(user.getRegistration_date());
		userSelected.setRole(user.getRole());
		userUpdated = userServiceImpl.update(userSelected);

		return userUpdated;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	// Delete user by id
	@DeleteMapping("/user/delete/{id}")
	public void delete(@PathVariable Integer id) {
		userServiceImpl.delete(id);
	}
	

}

