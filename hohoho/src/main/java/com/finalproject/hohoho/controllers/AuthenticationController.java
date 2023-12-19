package com.finalproject.hohoho.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.finalproject.hohoho.dto.User;
import com.finalproject.hohoho.dto.login.LoginRequest;
import com.finalproject.hohoho.dto.login.LoginResponse;
import com.finalproject.hohoho.dto.login.RegisterRequest;
import com.finalproject.hohoho.security.JwtUtils;
import com.finalproject.hohoho.security.service.UserDetailsServiceImpl;
import com.finalproject.hohoho.services.RoleServiceImpl;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    
    @Autowired
	private RoleServiceImpl roleServ;

    @Autowired
    private JwtUtils jwtUtils;
    
    @Autowired
	private PasswordEncoder encoder;

    @PostMapping("/login")
    public ResponseEntity<?> generateToken(@RequestBody LoginRequest loginRequest) throws Exception {
        try{
            autenticate(loginRequest.getName(),loginRequest.getPassword());
        }catch (Exception exception){
            exception.printStackTrace();
            throw new Exception("User not found");
        }

        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(loginRequest.getName());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new LoginResponse(token));
    }

    private void autenticate(String username,String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException exception){
            throw  new Exception("DESHABILITED USER " + exception.getMessage());
        }catch (BadCredentialsException e){
            throw  new Exception("Invalid credentials " + e.getMessage());
        }
    }

    @GetMapping("/actual-user")
    public User obtainActualUser(Principal principal){
        return (User) this.userDetailsService.loadUserByUsername(principal.getName());
    }
    
    @PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody RegisterRequest signUpRequest){
		Map<String, Object> responseData = new HashMap<String, Object>();
		   String name = signUpRequest.getName();
	
		if(userDetailsService.getUserByName(name) != null) {
	    responseData.put("Error", "Error: Username is already taken!");
		return ResponseEntity.badRequest().body(responseData);
		}

		ZoneId madridZone = ZoneId.of("Europe/Madrid");
		User user = new User();		
		user.setName(signUpRequest.getName());
		user.setPassword(this.encoder.encode(signUpRequest.getPassword()));
		user.setRole(this.roleServ.findByName("VISITOR").orElseThrow(() -> new RuntimeException("Not found"))); 
		user.setEmail(signUpRequest.getEmail());
		user.setRegistration_date(LocalDateTime.now(madridZone));
		this.userDetailsService.createUser(user);
		
		return ResponseEntity.ok("User created!");
	}
}