package java.finalproject.hohoho.controllers;

import java.finalproject.hohoho.dto.Services;
import java.finalproject.hohoho.services.ServicesServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ServiceController {

	@Autowired
	ServicesServiceImpl servicesServiceImpl;

	@GetMapping("/services")
	public List<Services> listar() {
		return servicesServiceImpl.listar();
	}

	@GetMapping("/service/{id}")
	public Services porIdentificador(@PathVariable(name = "id") Integer id) {
		return servicesServiceImpl.porIdentificador(id);
	}

	@PostMapping("/service/add")
	public Services guardar(@RequestBody Services services) {
		return servicesServiceImpl.guardar(services);
	}

	@PutMapping("/service/update/{id}")
	public Services actualizar(@PathVariable(name = "id") Integer id, @RequestBody Services services) {

		Services service_selected = new Services();
		Services service_updated = new Services();

		service_selected = servicesServiceImpl.porIdentificador(id);
		service_selected.setId(id);
		service_selected.setName(services.getName());
		service_updated = servicesServiceImpl.actualizar(service_selected);

		return service_updated;
	}

	@DeleteMapping("/service/delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		servicesServiceImpl.eliminar(id);
	}
}

