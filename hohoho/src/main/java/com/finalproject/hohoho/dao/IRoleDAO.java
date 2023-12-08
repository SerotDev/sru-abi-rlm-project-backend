package com.finalproject.hohoho.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.hohoho.dto.Role;

public interface IRoleDAO extends JpaRepository <Role, Integer>{
	Optional<Role> findByName(String User);
}
