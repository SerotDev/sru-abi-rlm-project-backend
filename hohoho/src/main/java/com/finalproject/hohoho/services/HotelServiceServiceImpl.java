package com.finalproject.hohoho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.hohoho.dao.IHotelServiceDAO;
import com.finalproject.hohoho.dto.HotelService;

@Service
public class HotelServiceServiceImpl implements IHotelServiceService{
	@Autowired
	IHotelServiceDAO iHotelServiceDAO;

	@Override
	public List<HotelService> list() {
		return iHotelServiceDAO.findAll();

	}

	@Override
	public HotelService save(HotelService hotelService) {
		return iHotelServiceDAO.save(hotelService);

	}

	@Override
	public HotelService byId(int id) {
		return iHotelServiceDAO.findById(id).get();

	}

	@Override
	public HotelService update(HotelService hotelService) {
		return iHotelServiceDAO.save(hotelService);

	}

	@Override
	public void delete(int id) {
		iHotelServiceDAO.deleteById(id);				
		
	}
	
}



