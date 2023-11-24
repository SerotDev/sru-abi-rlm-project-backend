package com.finalproject.hohoho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.hohoho.dao.IHotelEventDAO;
import com.finalproject.hohoho.dto.HotelEvent;

@Service
public class HotelEventServiceImpl implements IHotelEventService {
	@Autowired
	IHotelEventDAO iHotelEventDAO;

	@Override
	public List<HotelEvent> listar() {
		return iHotelEventDAO.findAll();

	}

	@Override
	public HotelEvent guardar(HotelEvent hotelEvent) {
		return iHotelEventDAO.save(hotelEvent);

	}

	@Override
	public HotelEvent porIdentificador(int id) {
		return iHotelEventDAO.findById(id).get();

	}

	@Override
	public HotelEvent actualizar(HotelEvent hotelEvent) {
		return iHotelEventDAO.save(hotelEvent);

	}

	@Override
	public void eliminar(int id) {
		iHotelEventDAO.deleteById(id);				
		
	}
	
}
