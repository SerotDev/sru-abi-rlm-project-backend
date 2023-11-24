package java.finalproject.hohoho.services;

import java.finalproject.hohoho.dto.Services;
import java.util.List;

public interface IServiceService {
	// CRUD models
	public List<Services> listar(); // List All

	public Services guardar(Services service); // (CREATE)

	public Services porIdentificador(int id); // (READ)

	public Services actualizar(Services service); // (UPDATE)

	public void eliminar(int id);// (DELETE)
}
