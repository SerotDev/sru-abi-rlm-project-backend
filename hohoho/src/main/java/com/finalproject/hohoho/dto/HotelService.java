package com.finalproject.hohoho.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "hotel_services")
public class HotelService {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_hotel")
	private Hotel hotel;
	
	@ManyToOne
	@JoinColumn(name = "id_service")
	private Services services;
	

	public HotelService() {
	}

	public HotelService(int id, Services services, Hotel hotel) {
		this.id = id;
		this.hotel = hotel;
		this.services = services;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Services getService() {
		return services;
	}

	public void setService(Services services) {
		this.services = services;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
}
