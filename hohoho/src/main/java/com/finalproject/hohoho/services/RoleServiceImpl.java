package com.finalproject.hohoho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.hohoho.dao.IRoleDAO;
import com.finalproject.hohoho.dto.Role;

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


