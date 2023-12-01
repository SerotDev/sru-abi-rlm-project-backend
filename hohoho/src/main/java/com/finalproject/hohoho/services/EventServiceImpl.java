package com.finalproject.hohoho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.hohoho.dao.IEventDAO;
import com.finalproject.hohoho.dto.Event;

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
	
}

