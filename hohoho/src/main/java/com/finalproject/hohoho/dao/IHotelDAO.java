package com.finalproject.hohoho.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.hohoho.dto.Hotel;
import com.finalproject.hohoho.dto.Town;
import com.finalproject.hohoho.dto.User;
import com.finalproject.hohoho.dto.Services;

public interface IHotelDAO extends JpaRepository <Hotel, Integer> {
	Page<Hotel> findAll(Pageable pageable);
	Page<Hotel> findByTown(Pageable pageable, Town town);
	Page<Hotel> findByNameContainingIgnoreCase(Pageable pageable, String search);
	Page<Hotel> findByNumberRoomsGreaterThanEqual(Pageable pageable, Integer minNumberRooms);
	Page<Hotel> findByPriceGreaterThanEqual(Pageable pageable, Integer minPrice);
	Page<Hotel> findByPriceGreaterThanEqualAndPriceLessThanEqual(Pageable pageable, Integer minPrice, Integer maxPrice);
	List<Hotel> findByHotelServices(Services services);
	List<Hotel> findByUser(User user); //Get hotels by user id

}
