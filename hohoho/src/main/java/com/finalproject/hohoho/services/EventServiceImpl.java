package com.finalproject.hohoho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.hohoho.dao.IEventDAO;
import com.finalproject.hohoho.dto.Event;
import com.finalproject.hohoho.dto.Hotel;

@Service
public class EventServiceImpl implements IEventService{
	@Autowired
IEventDAO iEventDAO;

	@Override
	public List<Event> list() {
		return iEventDAO.findAll();

	}

	@Override
	public Event save(Event event) {
		return iEventDAO.save(event);

	}

	@Override
	public Event byId(int id) {
		return iEventDAO.findById(id).get();

	}

	@Override
	public Event update(Event event) {
		return iEventDAO.save(event);

	}

	@Override
	public void delete(int id) {
		iEventDAO.deleteById(id);				
		
	}

	@Override
	public List<Event> privateEventByIdHotel(Hotel hotel) {
		return iEventDAO.findByIsPublicFalseAndHotel(hotel);
	}

	@Override
	public List<Event> publicEventByIdTown(Hotel hotel) {
		return iEventDAO.findByIsPublicTrueAndHotel(hotel);
	}

	@Override
	public List<Event> eventsByHotelId(Hotel hotel) {
		return iEventDAO.findByHotel(hotel);
	}
	
}

