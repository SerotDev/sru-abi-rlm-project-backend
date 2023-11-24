package java.finalproject.hohoho.services;

import java.finalproject.hohoho.dao.IServiceDAO;
import java.finalproject.hohoho.dto.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesServiceImpl implements IServiceService {
	@Autowired
	IServiceDAO iServiceDAO;

	@Override
	public List<Services> listar() {
		return iServiceDAO.findAll();

	}

	@Override
	public Services guardar(Services services) {
		return iServiceDAO.save(services);

	}

	@Override
	public Services porIdentificador(int id) {
		return iServiceDAO.findById(id).get();

	}

	@Override
	public Services actualizar(Services services) {
		return iServiceDAO.save(services);

	}

	@Override
	public void eliminar(int id) {
		iServiceDAO.deleteById(id);				
		
	}
	
}


