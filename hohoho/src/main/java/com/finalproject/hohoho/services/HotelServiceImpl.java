package com.finalproject.hohoho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.finalproject.hohoho.dao.IHotelDAO;
import com.finalproject.hohoho.dto.Hotel;

@Service
public class HotelServiceImpl implements IHotelService{
	@Autowired
	IHotelDAO iHotelDAO;

	@Override
	public List<Hotel> list() {
		return iHotelDAO.findAll();

	}
	
	@Override
	public Page<Hotel> getPaginatedHotels(Pageable pageable) {
		// TODO Auto-generated method stub
		return iHotelDAO.findAll(pageable);
	}

	@Override
	public Hotel save(Hotel hotel) {
		return iHotelDAO.save(hotel);

	}

	@Override
	public Hotel byId(int id) {
		return iHotelDAO.findById(id).get();

	}

	@Override
	public Hotel update(Hotel hotel) {
		return iHotelDAO.save(hotel);

	}

	@Override
	public void delete(int id) {
		iHotelDAO.deleteById(id);				
		
	}
	
}


