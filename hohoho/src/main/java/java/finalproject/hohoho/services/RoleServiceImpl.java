package java.finalproject.hohoho.services;

import java.finalproject.hohoho.dao.IRoleDAO;
import java.finalproject.hohoho.dto.Role;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {
		@Autowired
		IRoleDAO iRoleDAO;

		@Override
		public List<Role> listar() {
			return iRoleDAO.findAll();

		}

		@Override
		public Role guardar(Role role) {
			return iRoleDAO.save(role);

		}

		@Override
		public Role porIdentificador(int id) {
			return iRoleDAO.findById(id).get();

		}

		@Override
		public Role actualizar(Role role) {
			return iRoleDAO.save(role);

		}

		@Override
		public void eliminar(int id) {
			iRoleDAO.deleteById(id);				
			
		}
		
	}


