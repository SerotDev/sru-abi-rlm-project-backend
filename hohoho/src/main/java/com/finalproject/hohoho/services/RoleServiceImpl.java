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
		public List<Role> list() {
			return iRoleDAO.findAll();

		}

		@Override
		public Role save(Role role) {
			return iRoleDAO.save(role);

		}

		@Override
		public Role byId(int id) {
			return iRoleDAO.findById(id).get();

		}

		@Override
		public Role update(Role role) {
			return iRoleDAO.save(role);

		}

		@Override
		public void delete(int id) {
			iRoleDAO.deleteById(id);				
			
		}
		
	}


