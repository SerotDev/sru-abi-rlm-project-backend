package com.finalproject.hohoho.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "services")
public class Services {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;

	@ManyToMany(mappedBy = "hotelServices")
	@JsonIgnoreProperties("hotelServices")
	private List<Hotel> hotelServices;

	public Services() {
	}

	public Services(int id, String name, List<Hotel> hotelServices) {
		this.id = id;
		this.name = name;
		this.hotelServices = hotelServices;
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
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "HotelService")
	public List<Hotel> getHotelServices() {
		return hotelServices;
	}

	public void setHotelServices(List<Hotel> hotelServices) {
		this.hotelServices = hotelServices;
	}
}
