package com.finalproject.hohoho.dto;

import java.sql.Date;

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
	private String imgUrl;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
	@Column(name = "is_public")
	private Boolean isPublic;
	@Column(name = "entry_price")
	private Double entryPrice;
	@Column(name = "latitude")
	private Double latitude;
	@Column(name = "longitude")
	private Double longitude;
	
	@ManyToOne
	@JoinColumn(name = "id_hotel")
	private Hotel hotel;


	public Event() {
	}

	public Event(int id, String title, String description, String imgUrl, Date startDate, Date endDate,
			Double entryPrice, Boolean isPublic, Double latitude, Double longitude, Hotel hotel) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.imgUrl = imgUrl;
		this.startDate = startDate;
		this.endDate = endDate;
		this.entryPrice = entryPrice;
		this.isPublic = isPublic;
		this.latitude = latitude;
		this.longitude = longitude;
		this.hotel = hotel;
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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getEntryPrice() {
		return entryPrice;
	}

	public void setEntryPrice(Double entryPrice) {
		this.entryPrice = entryPrice;
	}
	
	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
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
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
}
