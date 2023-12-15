package com.finalproject.hohoho.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.hohoho.dto.AddFavourite;
import com.finalproject.hohoho.dto.Hotel;

public interface IAddFavouriteDAO extends JpaRepository <AddFavourite, Integer> {
	List<AddFavourite> findByUserId(Integer userId);
	List<AddFavourite> findByHotel(Hotel hotel);
}
