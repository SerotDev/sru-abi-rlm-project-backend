package java.finalproject.hohoho.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "hotel_services")
public class HotelService {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_services")
	private Services services;
	
	@ManyToOne
	@JoinColumn(name = "id_towns")
	private Hotel hotel;

	public HotelService() {
	}

	public HotelService(int id, Services services, Hotel hotel) {
		this.id = id;
		this.services = services;
		this.hotel = hotel;
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
