package java.finalproject.hohoho.services;

import java.finalproject.hohoho.dao.IUserDAO;
import java.finalproject.hohoho.dto.User;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	IUserDAO iUserDAO;

	@Override
	public List<User> listar() {
		return iUserDAO.findAll();

	}

	@Override
	public User guardar(User user) {
		return iUserDAO.save(user);

	}

	@Override
	public User porIdentificador(int id) {
		return iUserDAO.findById(id).get();

	}

	@Override
	public User actualizar(User user) {
		return iUserDAO.save(user);

	}

	@Override
	public void eliminar(int id) {
		iUserDAO.deleteById(id);				
		
	}
	
}
