package com.finalproject.hohoho.dto;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "events")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "img_url")
	private String img_url;
	@Column(name = "start_date")
	private Date start_date;
	@Column(name = "end_date")
	private Date end_date;
	@Column(name = "entry_price")
	private Double entry_price;
	@Column(name = "latitude")
	private Double latitude;
	@Column(name = "longitude")
	private Double longitude;
	
	@ManyToOne
	@JoinColumn(name = "id_town")
	private Town town;

	@OneToMany
	@JoinColumn(name = "id_events")
	private List<HotelEvent> hotelEvent;

	public Event() {
	}

	public Event(int id, String title, String description, String img_url, Date start_date, Date end_date,
			Double entry_price, Double latitude, Double longitude, Town town, List<HotelEvent> hotelEvent) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.img_url = img_url;
		this.start_date = start_date;
		this.end_date = end_date;
		this.entry_price = entry_price;
		this.latitude = latitude;
		this.longitude = longitude;
		this.town = town;
		this.hotelEvent = hotelEvent;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Double getEntry_price() {
		return entry_price;
	}

	public void setEntry_price(Double entry_price) {
		this.entry_price = entry_price;
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

	public Town getTown() {
		return town;
	}

	public void setTown(Town town) {
		this.town = town;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "HotelEvent")
	public List<HotelEvent> getHotelEvent() {
		return hotelEvent;
	}

	public void setHotelEvent(List<HotelEvent> hotelEvent) {
		this.hotelEvent = hotelEvent;
	}
	
}
