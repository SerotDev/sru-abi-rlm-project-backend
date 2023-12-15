package com.finalproject.hohoho.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.finalproject.hohoho.dto.AddFavourite;
import com.finalproject.hohoho.dto.Hotel;
import com.finalproject.hohoho.dto.Services;
import com.finalproject.hohoho.dto.Town;
import com.finalproject.hohoho.services.AddFavouriteServiceImpl;
import com.finalproject.hohoho.services.HotelServiceImpl;
import com.finalproject.hohoho.services.HotelServiceServiceImpl;
import com.finalproject.hohoho.services.ServicesServiceImpl;
import com.finalproject.hohoho.services.TownServiceImpl;

import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api")
public class HotelController {

	@Autowired
	HotelServiceImpl hotelServiceImpl;

	@Autowired
	TownServiceImpl townServiceImpl;

	@Autowired
	ServicesServiceImpl servicesServiceImpl;

	@Autowired
	AddFavouriteServiceImpl addFavouriteServiceImpl;

	// FILTROS - LOOK PAGINATION WHEN HAVE TO MULTIPLES RESULTS
	@GetMapping("/hotels/{page}{size}{idTown}{search}{minStarRatingAvg}{minNumberRooms}{minPrice}{maxPrice}{idServices}")
	public ResponseEntity<Map<String, Object>> filterHotels(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(name = "idTown", required = false) Integer idTown,
			@RequestParam(name = "search", required = false) String search,
			@RequestParam(name = "minStarRatingAvg", required = false) Integer minStarRatingAvg,
			@RequestParam(name = "minNumberRooms", required = false) Integer minNumberRooms,
			@RequestParam(name = "minPrice", required = false) Integer minPrice,
			@RequestParam(name = "maxPrice", required = false) Integer maxPrice,
			@RequestParam(name = "idServices", required = false) Integer[] idServices) {

		try {
			Pageable pageable = PageRequest.of(page, size);

			// TODO: List<Hotel> hotels = new ArrayList<Hotel>();
			Page<Hotel> pageHotels = null;

			int filterCounter = 0;

			// Endpoint have town parameter
			if (idTown != null) {
				// If its the first filter gets data paginated
				if (filterCounter == 0) {
					Town town = townServiceImpl.byId(idTown);
					pageHotels = hotelServiceImpl.listPageHotelsByTown(pageable, town);
					filterCounter++;
				}
				// if some filter is applied, gets data without pagination
				if (filterCounter > 0) {
					// <- TODO: add hotels by town not paginated HERE
				}
			}

			// Endpoint have search parameter
			if (search != null) {
				if (filterCounter == 0) {
					pageHotels = hotelServiceImpl.listPageHotelsBySearch(pageable, search);
					filterCounter++;
				}
				// if some filter is applied, gets data without pagination
				if (filterCounter > 0) {
					// <- TODO: add hotels by search not paginated HERE
				}
			}

			// Endpoint have minStarRatingAvg parameter
			if (minStarRatingAvg != null) {
				if (filterCounter == 0) {
					List<Hotel> hotelsAchieveRating = new ArrayList<Hotel>();
					List<Hotel> allHotels = hotelServiceImpl.list();
					// Compare if each hotel rating average is equals or greather than the field
					for (int i = 0; i < allHotels.size(); i++) {
						int hotelRatingAvg = getStarRatingAvgByHotelId(allHotels.get(i).getId());
						if (hotelRatingAvg >= minStarRatingAvg) {
							hotelsAchieveRating.add(allHotels.get(i));
						}
					}
					//Paginate the hotels list that achieve the rating
					int start = (int)pageable.getOffset();
					int end = Math.min((start + pageable.getPageSize()), hotelsAchieveRating.size());
					pageHotels = new PageImpl<>(hotelsAchieveRating.subList(start, end), pageable, hotelsAchieveRating.size());
					
					filterCounter++;
				}
				// if some filter is applied, gets data without pagination
				if (filterCounter > 0) {
					// <- TODO: add hotels by search not paginated HERE
				}
			}

			// Endpoint have minNumberRooms parameter
			if (minNumberRooms != null) {
				if (filterCounter == 0) {
					pageHotels = hotelServiceImpl.listPageHotelsByMinNumberRooms(pageable, minNumberRooms);
					filterCounter++;
				}
				// if some filter is applied, gets data without pagination
				if (filterCounter > 0) {
					// <- TODO: add hotels by search not paginated HERE
				}
			}

			// Endpoint have only min price parameter
			if (minPrice != null && maxPrice == null) {
				if (filterCounter == 0) {
					pageHotels = hotelServiceImpl.listPageHotelsByPrice(pageable, minPrice);
					filterCounter++;
				}
				// if some filter is applied, gets data without pagination
				if (filterCounter > 0) {
					// <- TODO: add hotels by search not paginated HERE
				}
				// Endpoint have only max price parameter
			} else if (minPrice == null && maxPrice != null) {
				if (filterCounter == 0) {
					pageHotels = hotelServiceImpl.listPageHotelsByPrice(pageable, 0, maxPrice);
					filterCounter++;
				}
				// if some filter is applied, gets data without pagination
				if (filterCounter > 0) {
					// <- TODO: add hotels by search not paginated HERE
				}
				// Endpoint have minPrice and maxPrice parameters
			} else if (minPrice != null && maxPrice != null) {
				if (filterCounter == 0) {
					pageHotels = hotelServiceImpl.listPageHotelsByPrice(pageable, minPrice, maxPrice);
					filterCounter++;
				}
				// if some filter is applied, gets data without pagination
				if (filterCounter > 0) {
					// <- TODO: add hotels by search not paginated HERE
				}
			}

			// Endpoint have idServices parameters
			if (idServices != null) {
				List<Services> hotelServices = new ArrayList<Services>();
				for (int i = 0; i < idServices.length; i++) {
					hotelServices.add(servicesServiceImpl.byId(idServices[i]));
				}
				if (filterCounter == 0) {
					pageHotels = hotelServiceImpl.listPageHotelsByServices(pageable, hotelServices);
					filterCounter++;
				}
				// if some filter is applied, gets data without pagination
				if (filterCounter > 0) {
					// <- TODO: add hotels by search not paginated HERE
				}
			}

			// if there are no filters get all hotels paginated
			if (filterCounter == 0) {
				pageHotels = hotelServiceImpl.listPageHotels(pageable);
				// if there are more than one filter convert list to page and save it in
				// pageHotels
			} else if (filterCounter > 1) {
				// <- HERE TODO: cleans duplicated items and convert list into page for save it
				// in pageHotels
				// TODO: new PageImpl<Hotel>(listOfHotels, pageable, listOfHotels.size());
			}

			// get data from page and return it as response.
			Map<String, Object> response = new HashMap<>();
			response.put("currentPage", pageHotels.getNumber());
			response.put("totalItems", pageHotels.getTotalElements());
			response.put("totalPages", pageHotels.getTotalPages());
			response.put("Hotels", pageHotels.getContent());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/hotel/starRatingAvg/{hotelId}")
	public int getStarRatingAvgByHotelId(@RequestParam(name = "hotelId", required = false) Integer hotelId) {
		Hotel hotel = hotelServiceImpl.byId(hotelId);
		List<AddFavourite> favourites = addFavouriteServiceImpl.listByHotel(hotel);
		int counter = 0;
		int sumStarRating = 0;
		for (int i = 0; i < favourites.size(); i++) {
			sumStarRating += favourites.get(i).getStarRating();
			counter++;
		}
		return (int) ((float) sumStarRating / (float) counter);
	}

	// Add new hotel
	@PreAuthorize("hasRole('ADMIN') or hasRole('HOTEL')")
	@PostMapping("/hotel/add")
	public Hotel save(@RequestBody Hotel hotel) {
		return hotelServiceImpl.save(hotel);
	}

	// Get hotel by id
	@GetMapping("/hotel/{id}")
	public Hotel byId(@PathVariable(name = "id") Integer id) {
		Hotel hotelByID = new Hotel();
		hotelByID = hotelServiceImpl.byId(id);
		return hotelByID;
	}

	// Update hotel by id
	@PreAuthorize("hasRole('ADMIN') or hasRole('HOTEL')")
	@PutMapping("/hotel/update/{id}")
	public Hotel update(@PathVariable(name = "id") Integer id, @RequestBody Hotel hotel) {

		Hotel hotelSelected = new Hotel();
		Hotel hotelUpdated = new Hotel();

		hotelSelected = hotelServiceImpl.byId(id);
		hotelSelected.setId(id);
		hotelSelected.setDescription(hotel.getDescription());
		hotelSelected.setPhone(hotel.getPhone());
		hotelSelected.setAddress(hotel.getAddress());
		hotelSelected.setEmail(hotel.getEmail());
		hotelSelected.setWeb(hotel.getWeb());
		hotelSelected.setNumberRooms(hotel.getNumberRooms());
		hotelSelected.setImgsUrl(hotel.getImgsUrl());
		hotelSelected.setPrice(hotel.getPrice());
		hotelSelected.setLatitude(hotel.getLatitude());
		hotelSelected.setLongitude(hotel.getLongitude());
		hotelSelected.setUser(hotel.getUser());
		hotelSelected.setTown(hotel.getTown());
		hotelUpdated = hotelServiceImpl.update(hotelSelected);

		return hotelUpdated;
	}

	@PreAuthorize("hasRole('ADMIN') or hasRole('HOTEL')")
	// Delete hotel by id
	@DeleteMapping("/hotel/delete/{id}")
	public void delete(@PathVariable Integer id) {
		hotelServiceImpl.delete(id);
	}
}
