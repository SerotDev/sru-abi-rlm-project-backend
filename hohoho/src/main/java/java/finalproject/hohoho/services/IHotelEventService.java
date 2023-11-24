package java.finalproject.hohoho.services;

import java.finalproject.hohoho.dto.HotelEvent;
import java.util.List;

public interface IHotelEventService {
	// CRUD models
	public List<HotelEvent> listar(); // List All

	public HotelEvent guardar(HotelEvent hotelEvent); // (CREATE)

	public HotelEvent porIdentificador(int id); // (READ)

	public HotelEvent actualizar(HotelEvent hotelEvent); // (UPDATE)

	public void eliminar(int id);// (DELETE)
}
