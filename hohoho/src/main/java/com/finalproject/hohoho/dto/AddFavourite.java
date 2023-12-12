package com.finalproject.hohoho.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "add_favourites")
public class AddFavourite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;

	@ManyToOne
	@JoinColumn(name = "id_hotel")
	private Hotel hotel;
	
	@Column(name = "star_rating")
	private int starRating;

	public AddFavourite() {
	}

	public AddFavourite(int id, Hotel hotel, User user, int starRating) {
		this.id = id;
		this.hotel = hotel;
		this.user = user;
		this.starRating = starRating;
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

	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}

}
