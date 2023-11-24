package java.finalproject.hohoho.controllers;

import java.finalproject.hohoho.dto.Event;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Falta implementar el service

@RestController
@RequestMapping("/api")
public class EventController {

	@Autowired
	EventServiceImpl eventServiceImpl;

	@GetMapping("/events")
	public List<Event> listar() {
		return eventServiceImpl.listar();
	}

	@GetMapping("/event/{id}")
	public Event porIdentificador(@PathVariable(name = "id") Integer id) {
		return eventServiceImpl.porIdentificador(id);
	}

	@PostMapping("/event/add")
	public Event guardar(@RequestBody Event event) {
		return eventServiceImpl.guardar(event);
	}

	@PutMapping("/event/update/{id}")
	public Event actualizar(@PathVariable(name = "id") Integer id, @RequestBody Event event) {

		Event event_selected = new Event();
		Event event_updated = new Event();

		event_selected = eventServiceImpl.porIdentificador(id);
		event_selected.setId(id);
		event_selected.setTitle(event.getTitle());
		event_selected.setDescription(event.getDescription());
		event_selected.setImg_url(event.getImg_url());
		event_selected.setStart_date(event.getStart_date());
		event_selected.setEnd_date(event.getEnd_date());
		event_selected.setEntry_price(event.getEntry_price());
		event_selected.setLatitude(event.getLatitude());
		event_selected.setLongitude(event.getLongitude());
		event_selected.setTown(event.getTown());
		
		event_updated = eventServiceImpl.actualizar(event_selected);

		return event_updated;
	}

	@DeleteMapping("/event/delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		eventServiceImpl.eliminar(id);
	}
}

