package java.finalproject.hohoho.services;

import java.finalproject.hohoho.dto.Role;
import java.util.List;

public interface IRoleService {
	// CRUD models
	public List<Role> listar(); // List All

	public Role guardar(Role role); // (CREATE)

	public Role porIdentificador(int id); // (READ)

	public Role actualizar(Role role); // (UPDATE)

	public void eliminar(int id);// (DELETE)
}
