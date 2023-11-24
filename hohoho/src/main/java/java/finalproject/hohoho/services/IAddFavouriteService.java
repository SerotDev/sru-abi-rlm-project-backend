package java.finalproject.hohoho.services;

import java.finalproject.hohoho.dto.AddFavourite;
import java.util.List;

public interface IAddFavouriteService {
	//CRUD models
	public List<AddFavourite> listar(); // List All

	public AddFavourite guardar(AddFavourite addFavourite); // (CREATE)

	public AddFavourite porIdentificador(int id); // (READ)

	public AddFavourite actualizar(AddFavourite addFavourite); // (UPDATE)

	public void eliminar(int id);// (DELETE)
}
