package com.finalproject.hohoho.jwt;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.hohoho.exceptions.UserNotFoundException;
import com.finalproject.hohoho.security.service.UserDetailsServiceImpl;
import com.finalproject.hohoho.services.UserServiceImpl;

import org.json.JSONObject;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class JWTController {
	@Autowired
    private JWTService jwtService;
	@Autowired
    private AuthenticationManager authenticationManager;
	@Autowired
    private UserDetailsServiceImpl userDetailsService;
	@Autowired
	private UserServiceImpl userServiceImpl;

    @PostMapping
    public Object getTokenForAuthenticatedUser(@RequestBody JWTAuthenticationRequest authRequest){
    	try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        	if (authentication.isAuthenticated()){
                String token =  jwtService.generateToken(authRequest.getUsername());
                UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("token",token);
                jsonObject.put("username",authRequest.getUsername());
                jsonObject.put("rol",userDetails.getAuthorities());
                jsonObject.put("id", userServiceImpl.byUserName(authRequest.getUsername()).getId());
                return jsonObject.toMap();//return token by body
            }
            else {
                throw new UserNotFoundException("Invalid user credentials");
            }
		} catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error", "Invalid user credentials");
            return jsonObject.toMap();//return token by body
		}
    }
}