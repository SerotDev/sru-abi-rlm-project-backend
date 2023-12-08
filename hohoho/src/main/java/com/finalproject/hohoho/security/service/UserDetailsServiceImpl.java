package com.finalproject.hohoho.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.finalproject.hohoho.dao.IUserDAO;
import com.finalproject.hohoho.dto.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private IUserDAO iUserDAO;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		var userEntity = this.iUserDAO.findByName(name);
		if (userEntity ==null) {
			throw new UsernameNotFoundException("User Not Found with user: " + name);
		}
		return UserDetailsImpl.build(userEntity);
	}
	
	public User createUser(User entity) {
		return iUserDAO.save(entity);
	}
	
    public User getUserByName(String name) {
        return iUserDAO.findByName(name);
    }

}
