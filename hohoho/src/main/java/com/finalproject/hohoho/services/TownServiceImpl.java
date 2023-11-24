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
	public List<Town> listar() {
		return iTownDAO.findAll();

	}

	@Override
	public Town guardar(Town town) {
		return iTownDAO.save(town);

	}

	@Override
	public Town porIdentificador(int id) {
		return iTownDAO.findById(id).get();

	}

	@Override
	public Town actualizar(Town town) {
		return iTownDAO.save(town);

	}

	@Override
	public void eliminar(int id) {
		iTownDAO.deleteById(id);				
		
	}
	
}



