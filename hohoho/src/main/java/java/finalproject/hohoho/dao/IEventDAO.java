package java.finalproject.hohoho.dao;

import java.finalproject.hohoho.dto.Event;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventDAO extends JpaRepository <Event, Integer> {

}
