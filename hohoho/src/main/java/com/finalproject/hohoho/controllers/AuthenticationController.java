package com.finalproject.hohoho.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.finalproject.hohoho.dto.User;
import com.finalproject.hohoho.dto.login.RegisterRequest;
import com.finalproject.hohoho.security.service.UserDetailsServiceImpl;
import com.finalproject.hohoho.services.RoleServiceImpl;
import com.finalproject.hohoho.services.UserServiceImpl;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    
    @Autowired
    private UserServiceImpl userService;
    
    @Autowired
	private RoleServiceImpl roleServ;
    
    @Autowired
	private PasswordEncoder encoder;

    @GetMapping("/actual-user")
    public User obtainActualUser(Principal principal){
        return (User) this.userDetailsService.loadUserByUsername(principal.getName());
    }
    
    @PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody RegisterRequest signUpRequest){
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		String username = signUpRequest.getUsername();
		
		if(userDetailsService.loadUserByUsername(username) != null) {
	    responseData.put("Error", "Error: Username is already taken!");
		return ResponseEntity.badRequest().body(responseData);
		}

		ZoneId madridZone = ZoneId.of("Europe/Madrid");
		User user = new User();		
		user.setName(signUpRequest.getUsername());
		user.setPassword(this.encoder.encode(signUpRequest.getPassword()));
		user.setRole(this.roleServ.findByName("VISITOR").orElseThrow(() -> new RuntimeException("Not found"))); 
		user.setEmail(signUpRequest.getEmail());
		user.setRegistration_date(LocalDateTime.now(madridZone));
		this.userService.save(user);
		
		return ResponseEntity.ok("User created!");
	}
}