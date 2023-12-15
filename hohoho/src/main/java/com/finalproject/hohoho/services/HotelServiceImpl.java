package com.finalproject.hohoho.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.finalproject.hohoho.dao.IHotelDAO;
import com.finalproject.hohoho.dto.Hotel;
import com.finalproject.hohoho.dto.Services;
import com.finalproject.hohoho.dto.Town;
import com.finalproject.hohoho.dto.User;

@Service
public class HotelServiceImpl implements IHotelService {
	@Autowired
	IHotelDAO iHotelDAO;

	@Override
	public List<Hotel> list() {
		return iHotelDAO.findAll();

	}

	/**
	 * List all hotels paginated
	 */
	@Override
	public Page<Hotel> listPageHotels(Pageable pageable) {
		return iHotelDAO.findAll(pageable);
	}

	/**
	 * List hotels by town paginated
	 */
	@Override
	public Page<Hotel> listPageHotelsByTown(Pageable pageable, Town town) {
		return iHotelDAO.findByTown(pageable, town);
	}

	/**
	 * List hotels by name search paginated
	 */
	@Override
	public Page<Hotel> listPageHotelsBySearch(Pageable pageable, String search) {
		return iHotelDAO.findByNameContainingIgnoreCase(pageable, search);
	}

	/**
	 * List hotels by minNumberRooms paginated
	 */
	@Override
	public Page<Hotel> listPageHotelsByMinNumberRooms(Pageable pageable, Integer minNumberRooms) {
		return iHotelDAO.findByNumberRoomsGreaterThanEqual(pageable, minNumberRooms);
	}

	/**
	 * List hotels by min price paginated
	 */
	@Override
	public Page<Hotel> listPageHotelsByPrice(Pageable pageable, Integer minPrice) {
		return iHotelDAO.findByPriceGreaterThanEqual(pageable, minPrice);
	}

	/**
	 * List hotels by price range paginated
	 */
	@Override
	public Page<Hotel> listPageHotelsByPrice(Pageable pageable, Integer minPrice, Integer maxPrice) {
		return iHotelDAO.findByPriceGreaterThanEqualAndPriceLessThanEqual(pageable, minPrice, maxPrice);
	}

	/**
	 * List hotels by services paginated
	 */
	@Override
	public List<Hotel> listPageHotelsByServices(List<Services> services) {
		// get all hotels by each service
		List<Hotel> hotels = new ArrayList<Hotel>();
		for (int i = 0; i < services.size(); i++) {
			List<Hotel> hotelsByService = iHotelDAO.findByHotelServices(services.get(i));
			for (int j = 0; j < hotelsByService.size(); j++) {
				hotels.add(hotelsByService.get(j));
			}
		}
		
		// filter to get only the repeated hotels
		List<Hotel> duplicatedHotels = new ArrayList<>();
		if (services.size() > 1) {
			Set<Hotel> setDupHotels = new HashSet<>();
			for (Hotel i : hotels) {
				if (setDupHotels.contains(i)) {
					duplicatedHotels.add(i);
				} else {
					setDupHotels.add(i);
				}
			}
		} else {
			duplicatedHotels.addAll(hotels);
		}

		return duplicatedHotels;
	}

	@Override
	public Hotel save(Hotel hotel) {
		return iHotelDAO.save(hotel);

	}

	@Override
	public Hotel byId(int id) {
		return iHotelDAO.findById(id).get();

	}

	@Override
	public Hotel update(Hotel hotel) {
		return iHotelDAO.save(hotel);

	}

	@Override
	public void delete(int id) {
		iHotelDAO.deleteById(id);

	}
	
	@Override
	public List<Hotel> listHotelsbyUser(User user) {
		return iHotelDAO.findByUser(user);
	}


}
