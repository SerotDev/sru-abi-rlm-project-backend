package com.finalproject.hohoho.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "hotels")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "phone")
	private String phone;
	@Column(name = "address")
	private String address;
	@Column(name = "email")
	private String email;
	@Column(name = "web")
	private String web;
	@Column(name = "number_rooms")
	private Integer number_rooms;
	@Column(name = "imgs_url")
	private String imgs_url;
	@Column(name = "price")
	private Double price;
	@Column(name = "latitude")
	private Double latitude;
	@Column(name = "longitude")
	private Double longitude;

	@OneToMany
	@JoinColumn(name = "id_hotel")
	private List<HotelService> hotelService;
	
	@ManyToOne
	@JoinColumn(name = "id_town")
	private Town town;

	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public Hotel() {
	}

	public Hotel(int id, String name, String description, String phone, String address, String email, String web,
			Integer number_rooms, String imgs_url, Double price, Double latitude, Double longitude,
			List<HotelService> hotelService, Town town, User user) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.web = web;
		this.number_rooms = number_rooms;
		this.imgs_url = imgs_url;
		this.price = price;
		this.latitude = latitude;
		this.longitude = longitude;
		this.hotelService = hotelService;
		this.town = town;
		this.user = user;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public Integer getNumber_rooms() {
		return number_rooms;
	}

	public void setNumber_rooms(Integer number_rooms) {
		this.number_rooms = number_rooms;
	}

	public String getImgs_url() {
		return imgs_url;
	}

	public void setImgs_url(String imgs_url) {
		this.imgs_url = imgs_url;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "HotelService")
	public List<HotelService> getHotelService() {
		return hotelService;
	}

	public void setHotelService(List<HotelService> hotelService) {
		this.hotelService = hotelService;
	}

	public Town getTown() {
		return town;
	}

	public void setTown(Town town) {
		this.town = town;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
