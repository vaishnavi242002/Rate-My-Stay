

 
package com.example.website.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.website.communicator.RatingServiceCommunicator;
import com.example.website.exception.HotelNotFoundException;
import com.example.website.hotel.Hotel;

@Service
public class HotelService {

	List<Hotel> hotelList=new ArrayList<>();
	
	Map<String,Hotel> hotelMap=new HashMap<>();
	@Autowired
	RatingServiceCommunicator ratingServiceCommunicator;
	
	public void createHotel(Hotel hotel) {
		Map<String,Long> ratingMap=new HashMap<>();
        hotelList.add(hotel);
		hotelMap.put(hotel.getId(), hotel);
		ratingMap.put(hotel.getId(), hotel.getRating());
		ratingServiceCommunicator.addRating(ratingMap);	
	}

	public Hotel getHotelById(String id) {
		if(ObjectUtils.isEmpty(hotelMap.get(id))) {
			throw new HotelNotFoundException("Hotel not found exception for id: "+id);
		}
		Hotel hotel=hotelMap.get(id);
		//rest service to fetch the data
		long updatedRating=ratingServiceCommunicator.getRating(id);
		hotel.setRating(updatedRating);
		
		return hotel;
		
	}
	
	public List<Hotel> getAllHotel(){
		
		return hotelList;
	}
	
	public void deleteHotelById(String id) {
		Hotel hotel=getHotelById(id);
		hotelList.remove(hotel);
		hotelMap.remove(id);
		ratingServiceCommunicator.deleteRating(id);
	}

	public void updateHotel(Hotel updatedHotel) {
		Hotel existingHotel=getHotelById( updatedHotel.getId());
		hotelList.remove(existingHotel);
		hotelList.add(updatedHotel);
		hotelMap.put(updatedHotel.getId(),updatedHotel);
		
		Map<String,Long> updatedRating=new HashMap<>();
		updatedRating.put(updatedHotel.getId(), updatedHotel.getRating());
		ratingServiceCommunicator.updateRating(updatedRating);
		
	}

}
