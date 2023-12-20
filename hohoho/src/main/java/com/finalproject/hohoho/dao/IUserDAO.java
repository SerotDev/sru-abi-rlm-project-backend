package com.finalproject.hohoho.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.hohoho.dto.User;

public interface IUserDAO extends JpaRepository <User, Integer> {
	Optional<User> findByName(String name);
	Optional<User> findByEmail(String email);
}
