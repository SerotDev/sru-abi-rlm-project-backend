package java.finalproject.hohoho.controllers;

import java.finalproject.hohoho.dto.Hotel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Falta implementar el service

@RestController
@RequestMapping("/api")
public class HotelController {

	@Autowired
	HotelServiceImpl hotelServiceImpl;

	@GetMapping("/hotels")
	public List<Hotel> listar() {
		return hotelServiceImpl.listar();
	}

	@GetMapping("/hotel/{id}")
	public Hotel porIdentificador(@PathVariable(name = "id") Integer id) {
		return hotelServiceImpl.porIdentificador(id);
	}

	@PostMapping("/hotel/add")
	public Hotel guardar(@RequestBody Hotel hotel) {
		return hotelServiceImpl.guardar(hotel);
	}

	@PutMapping("/hotel/update/{id}")
	public Hotel actualizar(@PathVariable(name = "id") Integer id, @RequestBody Hotel hotel) {

		Hotel hotel_selected = new Hotel();
		Hotel hotel_updated = new Hotel();

		hotel_selected = hotelServiceImpl.guardar(id);
		hotel_selected.setId(id);
		hotel_selected.setName(hotel.getName());
		hotel_selected.setDescription(hotel.getDescription());
		hotel_selected.setPhone(hotel.getPhone());
		hotel_selected.setAddress(hotel.getAddress());
		hotel_selected.setEmail(hotel.getEmail());
		hotel_selected.setWeb(hotel.getWeb());
		hotel_selected.setNumber_rooms(hotel.getNumber_rooms());
		hotel_selected.setImgs_url(hotel.getImgs_url());
		hotel_selected.setPrice(hotel.getPrice());
		hotel_selected.setLatitude(hotel.getLatitude());
		hotel_selected.setLongitude(hotel.getLongitude());
		hotel_selected.setTown(hotel.getTown());
		hotel_selected.setUser(hotel.getUser());
		
		hotel_updated = hotelServiceImpl.actualizar(hotel_selected);

		return hotel_updated;
	}

	@DeleteMapping("/hotel/delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		hotelServiceImpl.eliminar(id);
	}
}

