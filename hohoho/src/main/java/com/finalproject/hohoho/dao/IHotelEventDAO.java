package com.finalproject.hohoho.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.hohoho.dto.HotelEvent;

public interface IHotelEventDAO extends JpaRepository <HotelEvent, Integer> {

}
