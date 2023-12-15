package com.finalproject.hohoho.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.hohoho.dao.IAddFavouriteDAO;
import com.finalproject.hohoho.dto.AddFavourite;
import com.finalproject.hohoho.dto.Hotel;

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
	
	public List<Hotel> getFavouriteHotelsByUserId(Integer userId) {
		List<AddFavourite> addFavourites = iAddFavouriteDAO.findByUserId(userId);

        if (addFavourites == null || addFavourites.isEmpty()) {
            return Collections.emptyList();
        }

        return addFavourites.stream()
            .map(AddFavourite::getHotel)
            .collect(Collectors.toList());
    }

	@Override
	public List<AddFavourite> listByHotel(Hotel hotel) {
		return iAddFavouriteDAO.findByHotel(hotel);
	}
	
}



