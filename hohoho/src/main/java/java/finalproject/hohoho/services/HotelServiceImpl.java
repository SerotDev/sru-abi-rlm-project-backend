package java.finalproject.hohoho.services;

import java.finalproject.hohoho.dao.IHotelDAO;
import java.finalproject.hohoho.dto.Hotel;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements IHotelService{
	@Autowired
	IHotelDAO iHotelDAO;

	@Override
	public List<Hotel> listar() {
		return iHotelDAO.findAll();

	}

	@Override
	public Hotel guardar(Hotel hotel) {
		return iHotelDAO.save(hotel);

	}

	@Override
	public Hotel porIdentificador(int id) {
		return iHotelDAO.findById(id).get();

	}

	@Override
	public Hotel actualizar(Hotel hotel) {
		return iHotelDAO.save(hotel);

	}

	@Override
	public void eliminar(int id) {
		iHotelDAO.deleteById(id);				
		
	}
	
}


