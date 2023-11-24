package java.finalproject.hohoho.services;

import java.finalproject.hohoho.dao.IServiceDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements IServiceService {
	@Autowired
	IServiceDAO iServiceDAO;

	@Override
	public List<Service> listar() {
		return iServiceDAO.findAll();

	}

	@Override
	public Service guardar(Service service) {
		return iServiceDAO.save(service);

	}

	@Override
	public Service porIdentificador(int id) {
		return iServiceDAO.findById(id).get();

	}

	@Override
	public Service actualizar(Service service) {
		return iServiceDAO.save(service);

	}

	@Override
	public void eliminar(int id) {
		iServiceDAO.deleteById(id);				
		
	}
	
}


