package com.finalproject.hohoho.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.finalproject.hohoho.dto.Event;
import com.finalproject.hohoho.dto.Hotel;
import com.finalproject.hohoho.dto.User;
import com.finalproject.hohoho.services.AddFavouriteServiceImpl;
import com.finalproject.hohoho.services.EventServiceImpl;
import com.finalproject.hohoho.services.HotelServiceImpl;
import com.finalproject.hohoho.services.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	HotelServiceImpl hotelServiceImpl;
	
	@Autowired
	EventServiceImpl eventServiceImpl;
	
	@Autowired
	AddFavouriteServiceImpl addFavouriteServiceImpl;

	// Get all users
	@GetMapping("/users")
	public List<User> list() {
		return userServiceImpl.list();
	}
	
	// Add new user
	@PostMapping("/user/add")
	public User save(@RequestBody User user) {
		return userServiceImpl.save(user);
	}
	
	// Get user by id
	@GetMapping("/user/{id}")
	public User byId(@PathVariable(name = "id") Integer id) {
		User userByID = new User();
		userByID = userServiceImpl.byId(id);
		return userByID;
	}
	/*Get user myUser
	@GetMapping("/user/myUser")
	public User myUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails =(UserDetails)auth.getPrincipal();
        User user = userServiceImpl.byUserName(userDetails.getUsername());
        return user;
	}*/
	
	// Get hotel by user id
	@GetMapping("/user/hotels/{idUser}")
	public List <Hotel> listHotelsbyUser(@PathVariable(name = "idUser")Integer idUser){
		User user = userServiceImpl.byId(idUser);
		return hotelServiceImpl.listHotelsbyUser(user);		
	}
	
	//Get events by hotel id
	@GetMapping("/user/events/{idHotel}")
	public List <Event> eventsByHotelId(@PathVariable(name = "idHotel")Integer idHotel){
		Hotel hotel = hotelServiceImpl.byId(idHotel);
		return eventServiceImpl.eventsByHotelId(hotel);	
	}
	
	//Get favourite hotels by user id
    @GetMapping("/user/favouriteHotels/{userId}")
    public ResponseEntity<List<Hotel>> getFavouriteHotelsByUserId(@PathVariable Integer userId) {
        List<Hotel> favouriteHotels = addFavouriteServiceImpl.getFavouriteHotelsByUserId(userId);

        if (favouriteHotels == null || favouriteHotels.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(favouriteHotels);
    }
	
	// Update user by id
	@PutMapping("/user/update/{id}")
	public User update(@PathVariable(name = "id") Integer id, @RequestBody User user) {

		User userSelected = new User();
		User userUpdated = new User();

		userSelected = userServiceImpl.byId(id);
		userSelected.setId(id);
		userSelected.setName(user.getName());
		userSelected.setSurname(user.getSurname());
		userSelected.setPhone(user.getPhone());
		userSelected.setProfImgUrl(user.getProfImgUrl());
		userSelected.setEmail(user.getEmail());
		userSelected.setPassword(user.getPassword());
		userSelected.setRegistration_date(user.getRegistrationDate());
		userSelected.setRole(user.getRole());
		userUpdated = userServiceImpl.update(userSelected);

		return userUpdated;
	}
	
	// Delete user by id
	@DeleteMapping("/user/delete/{id}")
	public void delete(@PathVariable Integer id) {
		userServiceImpl.delete(id);
	}
	

}

