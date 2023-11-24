package java.finalproject.hohoho.controllers;
import java.finalproject.hohoho.dto.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Falta implementar el service

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@GetMapping("/users")
	public List<User> listar() {
		return userServiceImpl.listar();
	}

	@GetMapping("/user/{id}")
	public User porIdentificador(@PathVariable(name = "id") Integer id) {
		return userServiceImpl.porIdentificador(id);
	}

	@PostMapping("/user/add")
	public User guardar(@RequestBody User user) {
		return userServiceImpl.guardar(user);
	}

	@PutMapping("/user/update/{id}")
	public User actualizar(@PathVariable(name = "id") Integer id, @RequestBody User user) {

		User user_selected = new User();
		User user_updated = new User();

		user_selected = userServiceImpl.porIdentificador(id);
		user_selected.setId(id);
		user_selected.setName(user.getName());
		user_selected.setSurnames(user.getSurnames());
		user_selected.setPhone(user.getPhone());
		user_selected.setProf_img_url(user.getProf_img_url());
		user_selected.setEmail(user.getEmail());
		user_selected.setPassword(user.getPassword());
		user_selected.setRegistration_date(user.getRegistration_date());
		user_selected.setRole(user.getRole());
		
		user_updated = userServiceImpl.actualizar(user_selected);

		return user_updated;
	}

	@DeleteMapping("/user/delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		userServiceImpl.eliminar(id);
	}
}


