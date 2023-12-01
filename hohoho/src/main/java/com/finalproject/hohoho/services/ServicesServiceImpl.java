package com.finalproject.hohoho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.hohoho.dao.IServicesDAO;
import com.finalproject.hohoho.dto.Services;

@Service
public class ServicesServiceImpl implements IServicesService {
	@Autowired
	IServicesDAO iServiceDAO;

	@Override
	public List<Services> list() {
		return iServiceDAO.findAll();

	}

	@Override
	public Services save(Services services) {
		return iServiceDAO.save(services);

	}

	@Override
	public Services byId(int id) {
		return iServiceDAO.findById(id).get();

	}

	@Override
	public Services update(Services services) {
		return iServiceDAO.save(services);

	}

	@Override
	public void delete(int id) {
		iServiceDAO.deleteById(id);				
		
	}
	
}


