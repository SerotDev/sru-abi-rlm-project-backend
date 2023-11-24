package java.finalproject.hohoho.dao;

import java.finalproject.hohoho.dto.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IHotelDAO extends JpaRepository <Hotel, Integer> {

}
