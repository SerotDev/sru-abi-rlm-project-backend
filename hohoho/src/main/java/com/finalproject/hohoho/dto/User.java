package com.finalproject.hohoho.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;
	@Column(name = "phone")
	private String phone;
	@Column(name = "prof_img_url")
	private String profImgUrl;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "registration_date")
	private LocalDateTime registrationDate;
	
	@ManyToOne
	@JoinColumn(name = "id_role")
	private Role role;

	@OneToMany
	@JoinColumn(name = "id_user")
	private List<Hotel> hotel;
	
	@OneToMany
	@JoinColumn(name = "id_user")
	private List<AddFavourite> addFavourite;

	public User() {
	}

	public User(int id, String name, String surname, String phone, String profImgUrl, String email, String password,
			LocalDateTime registrationDate, Role role, List<Hotel> hotel, List<AddFavourite> addFavourite) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.profImgUrl = profImgUrl;
		this.email = email;
		this.password = password;
		this.registrationDate = registrationDate;
		this.role = role;
		this.hotel = hotel;
		this.addFavourite = addFavourite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProf_img_url() {
		return profImgUrl;
	}

	public void setProf_img_url(String profImgUrl) {
		this.profImgUrl = profImgUrl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getRegistration_date() {
		return registrationDate;
	}

	public void setRegistration_date(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Hotel")
	public List<Hotel> getHotel() {
		return hotel;
	}

	public void setHotel(List<Hotel> hotel) {
		this.hotel = hotel;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "AddFavourite")
	public List<AddFavourite> getAddFavourite() {
		return addFavourite;
	}

	public void setAddFavourite(List<AddFavourite> addFavourite) {
		this.addFavourite = addFavourite;
	}

	

}