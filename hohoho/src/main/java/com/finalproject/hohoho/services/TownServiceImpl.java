package com.finalproject.hohoho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.hohoho.dao.ITownDAO;
import com.finalproject.hohoho.dto.Town;

@Service
public class TownServiceImpl implements ITownService{
	@Autowired
	ITownDAO iTownDAO;

	@Override
	public List<Town> list() {
		return iTownDAO.findAll();

	}

	@Override
	public Town save(Town town) {
		return iTownDAO.save(town);

	}

	@Override
	public Town byId(int id) {
		return iTownDAO.findById(id).get();

	}

	@Override
	public Town update(Town town) {
		return iTownDAO.save(town);

	}

	@Override
	public void delete(int id) {
		iTownDAO.deleteById(id);				
		
	}
	
}



