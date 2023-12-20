package com.finalproject.hohoho.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.finalproject.hohoho.dao.IUserDAO;
import com.finalproject.hohoho.dto.User;

/**
 * @author Jose Marin
 */

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserDAO usuarioDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	if(usuarioDAO.findByName(username).equals(Optional.empty())) 
    	{
    		return null;
    	}
        return usuarioDAO.findByName(username)
                .map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException("No user found"));
    }

    public Optional<User> loadUserByEmail(String email) {
    	if(usuarioDAO.findByEmail(email).equals(Optional.empty())) 
    	{
    		return null;
    	}
        return usuarioDAO.findByEmail(email);
    }
}