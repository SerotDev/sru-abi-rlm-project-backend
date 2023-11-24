package java.finalproject.hohoho.controllers;

import java.finalproject.hohoho.dto.HotelService;
import java.finalproject.hohoho.services.HotelServiceServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HotelServiceController {

	@Autowired
	HotelServiceServiceImpl hotelServiceServiceImpl;

	@GetMapping("/hotel_services")
	public List<HotelService> listar() {
		return hotelServiceServiceImpl.listar();
	}

	@GetMapping("/hotel_service/{id}")
	public HotelService porIdentificador(@PathVariable(name = "id") Integer id) {
		return hotelServiceServiceImpl.porIdentificador(id);
	}

	@PostMapping("/hotel_service/add")
	public HotelService guardar(@RequestBody HotelService hotelService) {
		return hotelServiceServiceImpl.guardar(hotelService);
	}

	@PutMapping("/hotel_service/update/{id}")
	public HotelService actualizar(@PathVariable(name = "id") Integer id, @RequestBody HotelService hotelService) {

		HotelService hotel_service_selected = new HotelService();
		HotelService hotel_service_updated = new HotelService();

		hotel_service_selected = hotelServiceServiceImpl.porIdentificador(id);
		hotel_service_selected.setId(id);
		hotel_service_selected.setHotel(hotelService.getHotel());
		hotel_service_selected.setService(hotelService.getService());
		hotel_service_updated = hotelServiceServiceImpl.actualizar(hotel_service_selected);
		
		return hotel_service_updated;
	}

	@DeleteMapping("/hotel_service/delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		hotelServiceServiceImpl.eliminar(id);
	}
}

