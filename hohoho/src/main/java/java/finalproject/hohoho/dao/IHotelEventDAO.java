package java.finalproject.hohoho.dao;

import java.finalproject.hohoho.dto.HotelEvent;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IHotelEventDAO extends JpaRepository <HotelEvent, Integer> {

}
