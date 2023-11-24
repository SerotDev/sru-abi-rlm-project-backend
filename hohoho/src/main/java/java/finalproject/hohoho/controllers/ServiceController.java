package java.finalproject.hohoho.controllers;

import java.finalproject.hohoho.dto.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Falta implementar el service

@RestController
@RequestMapping("/api")
public class ServiceController {

	@Autowired
	ServiceServiceImpl serviceServiceImpl;

	@GetMapping("/services")
	public List<Service> listar() {
		return serviceServiceImpl.listar();
	}

	@GetMapping("/service/{id}")
	public Service porIdentificador(@PathVariable(name = "id") Integer id) {
		return serviceServiceImpl.porIdentificador(id);
	}

	@PostMapping("/service/add")
	public Service guardar(@RequestBody Service service) {
		return serviceServiceImpl.guardar(service);
	}

	@PutMapping("/service/update/{id}")
	public Service actualizar(@PathVariable(name = "id") Integer id, @RequestBody Service service) {

		Service service_selected = new Service();
		Service service_updated = new Service();

		service_selected = serviceServiceImpl.porIdentificador(id);
		service_selected.setId(id);
		service_selected.setName(service.getName());
		service_updated = serviceServiceImpl.actualizar(service_selected);

		return service_updated;
	}

	@DeleteMapping("/service/delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		serviceServiceImpl.eliminar(id);
	}
}

