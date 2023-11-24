package java.finalproject.hohoho.dao;

import java.finalproject.hohoho.dto.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDAO extends JpaRepository <User, Integer> {

}
