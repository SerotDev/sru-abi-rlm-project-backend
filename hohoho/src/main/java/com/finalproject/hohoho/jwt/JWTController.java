package com.finalproject.hohoho.jwt;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.hohoho.exceptions.UserNotFoundException;
import org.json.JSONObject;

/**
 * @author Samson Effes
 */


@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class JWTController {
	@Autowired
    private JWTService jwtService;
	@Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public Object getTokenForAuthenticatedUser(@RequestBody JWTAuthenticationRequest authRequest){
    	System.out.println(authRequest.getUsername());
    	System.out.println(authRequest.getPassword());
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()){
            String token =  jwtService.generateToken(authRequest.getUsername());
            JSONObject jsonObject = new JSONObject("{\"token\": \"" + token + "\"}");
            jsonObject.put("token",token );
            return jsonObject.toMap();//devuelve token por body
        }
        else {
        	System.out.println("Fallo");
            throw new UserNotFoundException("Invalid user credentials");
        }
    }
}