package java.finalproject.hohoho.services;

import java.finalproject.hohoho.dao.IHotelServiceDAO;
import java.finalproject.hohoho.dto.HotelService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceServiceImpl implements IHotelServiceService{
	@Autowired
	IHotelServiceDAO iHotelServiceDAO;

	@Override
	public List<HotelService> listar() {
		return iHotelServiceDAO.findAll();

	}

	@Override
	public HotelService guardar(HotelService hotelService) {
		return iHotelServiceDAO.save(hotelService);

	}

	@Override
	public HotelService porIdentificador(int id) {
		return iHotelServiceDAO.findById(id).get();

	}

	@Override
	public HotelService actualizar(HotelService hotelService) {
		return iHotelServiceDAO.save(hotelService);

	}

	@Override
	public void eliminar(int id) {
		iHotelServiceDAO.deleteById(id);				
		
	}
	
}



