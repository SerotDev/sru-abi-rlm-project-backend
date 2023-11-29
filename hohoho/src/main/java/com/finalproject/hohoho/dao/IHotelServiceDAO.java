package com.finalproject.hohoho.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.hohoho.dto.HotelService;

public interface IHotelServiceDAO extends JpaRepository <HotelService, Integer> {

}
