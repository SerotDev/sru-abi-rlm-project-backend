package java.finalproject.hohoho.services;

import java.finalproject.hohoho.dto.Service;
import java.util.List;

public interface IServiceService {
	// CRUD models
	public List<Service> listar(); // List All

	public Service guardar(Service service); // (CREATE)

	public Service porIdentificador(int id); // (READ)

	public Service actualizar(Service service); // (UPDATE)

	public void eliminar(int id);// (DELETE)
}
