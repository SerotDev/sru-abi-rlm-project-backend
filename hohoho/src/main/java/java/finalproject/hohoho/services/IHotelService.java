package java.finalproject.hohoho.services;

import java.finalproject.hohoho.dto.Hotel;
import java.util.List;

public interface IHotelService {
	// CRUD models
	public List<Hotel> listar(); // List All

	public Hotel guardar(Hotel hotel); // (CREATE)

	public Hotel porIdentificador(int id); // (READ)

	public Hotel actualizar(Hotel hotel); // (UPDATE)

	public void eliminar(int id);// (DELETE)
}
