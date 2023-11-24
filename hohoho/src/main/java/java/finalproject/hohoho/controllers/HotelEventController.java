package java.finalproject.hohoho.controllers;

import java.finalproject.hohoho.dto.HotelEvent;
import java.finalproject.hohoho.services.HotelEventServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HotelEventController {

	@Autowired
	HotelEventServiceImpl hotelEventServiceImpl;

	@GetMapping("/hotels_events")
	public List<HotelEvent> listar() {
		return hotelEventServiceImpl.listar();
	}

	@GetMapping("/hotel_event/{id}")
	public HotelEvent porIdentificador(@PathVariable(name = "id") Integer id) {
		return hotelEventServiceImpl.porIdentificador(id);
	}

	@PostMapping("/hotel_event/add")
	public HotelEvent guardar(@RequestBody HotelEvent hotelEvent) {
		return hotelEventServiceImpl.guardar(hotelEvent);
	}

	@PutMapping("/hotel_event/update/{id}")
	public HotelEvent actualizar(@PathVariable(name = "id") Integer id, @RequestBody HotelEvent hotelEvent) {

		HotelEvent hotel_event_selected = new HotelEvent();
		HotelEvent hotel_event_updated = new HotelEvent();

		hotel_event_selected = hotelEventServiceImpl.porIdentificador(id);
		hotel_event_selected.setId(id);
		hotel_event_selected.setEvent(hotelEvent.getEvent());
		hotel_event_selected.setHotel(hotelEvent.getHotel());
		hotel_event_selected.setIs_public(hotelEvent.getIs_public());
		hotel_event_updated = hotelEventServiceImpl.actualizar(hotel_event_selected);

		return hotel_event_updated;
	}

	@DeleteMapping("/hotel_event/delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		hotelEventServiceImpl.eliminar(id);
	}
}

