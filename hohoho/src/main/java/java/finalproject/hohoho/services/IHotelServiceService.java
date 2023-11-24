package java.finalproject.hohoho.services;

import java.finalproject.hohoho.dto.HotelService;
import java.util.List;

public interface IHotelServiceService {
	// CRUD models
	public List<HotelService> listar(); // List All

	public HotelService guardar(HotelService hotelService); // (CREATE)

	public HotelService porIdentificador(int id); // (READ)

	public HotelService actualizar(HotelService hotelService); // (UPDATE)

	public void eliminar(int id);// (DELETE)
}
