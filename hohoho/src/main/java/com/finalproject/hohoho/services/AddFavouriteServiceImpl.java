package com.finalproject.hohoho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.hohoho.dao.IAddFavouriteDAO;
import com.finalproject.hohoho.dto.AddFavourite;

@Service
public class AddFavouriteServiceImpl implements IAddFavouriteService{
	@Autowired
	IAddFavouriteDAO iAddFavouriteDAO;

	@Override
	public List<AddFavourite> list() {
		return iAddFavouriteDAO.findAll();

	}

	@Override
	public AddFavourite save(AddFavourite addFavourite) {
		return iAddFavouriteDAO.save(addFavourite);

	}

	@Override
	public AddFavourite byId(int id) {
		return iAddFavouriteDAO.findById(id).get();

	}

	@Override
	public AddFavourite update(AddFavourite addFavourite) {
		return iAddFavouriteDAO.save(addFavourite);

	}

	@Override
	public void delete(int id) {
		iAddFavouriteDAO.deleteById(id);				
		
	}
	
}



