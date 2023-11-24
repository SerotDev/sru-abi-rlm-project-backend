package com.finalproject.hohoho.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "add_favourites")
public class AddFavourite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_hotels")
	private Hotel hotel;

	@ManyToOne
	@JoinColumn(name = "id_users")
	private User user;
	
	@Column(name = "star_rating")
	private String star_rating;

	public AddFavourite() {
	}

	public AddFavourite(int id, Hotel hotel, User user, String star_rating) {
		super();
		this.id = id;
		this.hotel = hotel;
		this.user = user;
		this.star_rating = star_rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStar_rating() {
		return star_rating;
	}

	public void setStar_rating(String star_rating) {
		this.star_rating = star_rating;
	}

}
