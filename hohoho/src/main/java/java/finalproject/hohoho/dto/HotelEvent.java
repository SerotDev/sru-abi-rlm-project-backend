package java.finalproject.hohoho.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "hotels_events")
public class HotelEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_hotels")
	private Hotel hotel;
	
	@ManyToOne
	@JoinColumn(name = "id_events")
	private Event event;

	public HotelEvent() {
	}

	public HotelEvent(int id, Hotel hotel, Event event) {
		this.id = id;
		this.hotel = hotel;
		this.event = event;
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

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
}