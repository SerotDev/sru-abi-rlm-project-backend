package com.finalproject.hohoho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.finalproject.hohoho.dao.IHotelDAO;
import com.finalproject.hohoho.dto.Hotel;
import com.finalproject.hohoho.dto.Services;
import com.finalproject.hohoho.dto.Town;

@Service
public class HotelServiceImpl implements IHotelService{
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
	 * List hotels by minimum StarRating Average paginated
	 */
	@Override
	public Page<Hotel> listPageHotelsByStarRatingAvg(Pageable pageable, Integer minStarRatingAvg) {
		//return iHotelDAO.findByMinStarRatingAvg(pageable, minStarRatingAvg);
		return null;
	}

	/**
	 *  List hotels by minNumberRooms paginated
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
	public Page<Hotel> listPageHotelsByServices(Pageable pageable, List<Services> services) {
		return iHotelDAO.findByHotelServicesIn(pageable, services);
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
	
}


