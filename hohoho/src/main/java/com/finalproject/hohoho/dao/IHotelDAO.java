package com.finalproject.hohoho.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.hohoho.dto.Hotel;

public interface IHotelDAO extends JpaRepository <Hotel, Integer> {

}
