package java.finalproject.hohoho.services;

import java.finalproject.hohoho.dao.IAddFavouriteDAO;
import java.finalproject.hohoho.dto.AddFavourite;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddFavouriteServiceImpl implements IAddFavouriteService{
	@Autowired
	IAddFavouriteDAO iAddFavouriteDAO;

	@Override
	public List<AddFavourite> listar() {
		return iAddFavouriteDAO.findAll();

	}

	@Override
	public AddFavourite guardar(AddFavourite addFavourite) {
		return iAddFavouriteDAO.save(addFavourite);

	}

	@Override
	public AddFavourite porIdentificador(int id) {
		return iAddFavouriteDAO.findById(id).get();

	}

	@Override
	public AddFavourite actualizar(AddFavourite addFavourite) {
		return iAddFavouriteDAO.save(addFavourite);

	}

	@Override
	public void eliminar(int id) {
		iAddFavouriteDAO.deleteById(id);				
		
	}
	
}



