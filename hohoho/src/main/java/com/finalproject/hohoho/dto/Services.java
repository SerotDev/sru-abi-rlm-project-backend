package com.finalproject.hohoho.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "services")
public class Services {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;

	@OneToMany
	@JoinColumn(name = "id_services")
	private List<HotelService> hotelService;

	public Services() {
	}

	public Services(int id, String name, List<HotelService> hotelService) {
		this.id = id;
		this.name = name;
		this.hotelService = hotelService;
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
	public List<HotelService> getHotelService() {
		return hotelService;
	}

	public void setHotelService(List<HotelService> hotelService) {
		this.hotelService = hotelService;
	}
}
