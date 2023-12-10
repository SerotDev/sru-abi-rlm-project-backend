package com.finalproject.hohoho.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.hohoho.dto.Hotel;
import com.finalproject.hohoho.dto.Town;

public interface IHotelDAO extends JpaRepository <Hotel, Integer> {
	Page<Hotel> findAll(Pageable pageable);
	Page<Hotel> findByTown(Pageable pageable, Town town);
	Page<Hotel> findByNameContainingIgnoreCase(Pageable pageable, String search);
	//Page<Hotel> findByMinStarRatingAvg(Pageable pageable, Integer minStarRatingAvg);
	Page<Hotel> findByNumberRoomsGreaterThanEqual(Pageable pageable, Integer minNumberRooms);
	Page<Hotel> findByPriceGreaterThanEqual(Pageable pageable, Integer minPrice);
	Page<Hotel> findByPriceGreaterThanEqualAndPriceLessThanEqual(Pageable pageable, Integer minPrice, Integer maxPrice);
	//Page<Hotel> findByServices(Pageable pageable, List<Services> services);
}
