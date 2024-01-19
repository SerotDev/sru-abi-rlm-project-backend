package com.finalproject.hohoho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.hohoho.dao.IUserDAO;
import com.finalproject.hohoho.dto.User;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	IUserDAO iUserDAO;

	@Override
	public List<User> list() {
		return iUserDAO.findAll();

	}

	@Override
	public User save(User user) {
		return iUserDAO.save(user);

	}

	@Override
	public User byId(int id) {
		return iUserDAO.findById(id).get();

	}

	@Override
	public User update(User user) {
		return iUserDAO.save(user);

	}

	@Override
	public void delete(int id) {
		iUserDAO.deleteById(id);				
		
	}

	@Override
	public User byUserName(String username) {
		return iUserDAO.findByName(username).get();
	}
	
}
