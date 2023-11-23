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
	private Service service;
	
	@ManyToOne
	@JoinColumn(name = "id_towns")
	private Hotel hotel;

	public HotelService() {
	}

	public HotelService(int id, Service service, Hotel hotel) {
		this.id = id;
		this.service = service;
		this.hotel = hotel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
}
