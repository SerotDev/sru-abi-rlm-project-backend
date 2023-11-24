package com.finalproject.hohoho.dto;

import java.sql.Date;
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
	@Column(name = "surnames")
	private String surnames;
	@Column(name = "phone")
	private String phone;
	@Column(name = "prof_img_url")
	private String prof_img_url;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "registration_date")
	private Date registration_date;
	
	@ManyToOne
	@JoinColumn(name = "id_role")
	private Role role;

	@OneToMany
	@JoinColumn(name = "id_user")
	private List<Hotel> hotel;

	public User() {
	}

	public User(int id, String name, String surnames, String phone, String prof_img_url, String email, String password,
			Date registration_date, List<Hotel> hotel, Role role) {
		this.id = id;
		this.name = name;
		this.surnames = surnames;
		this.phone = phone;
		this.prof_img_url = prof_img_url;
		this.email = email;
		this.password = password;
		this.registration_date = registration_date;
		this.hotel = hotel;
		this.role = role;
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

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProf_img_url() {
		return prof_img_url;
	}

	public void setProf_img_url(String prof_img_url) {
		this.prof_img_url = prof_img_url;
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

	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Hotel")
	public List<Hotel> getHotels() {
		return hotel;
	}

	public void setHotels(List<Hotel> hotel) {
		this.hotel = hotel;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
