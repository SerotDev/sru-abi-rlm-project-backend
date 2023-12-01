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
	private int star_rating;

	public AddFavourite() {
	}

	public AddFavourite(int id, Hotel hotel, User user, int star_rating) {
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

	public int getStar_rating() {
		return star_rating;
	}

	public void setStar_rating(int star_rating) {
		this.star_rating = star_rating;
	}

}
