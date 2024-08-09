package com.example.website.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.website.hotel.Hotel;
import com.example.website.service.HotelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	HotelService hotelService;
   
	@PostMapping("/create")
	public void createHotel( @Valid @RequestBody Hotel hotel,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new RuntimeException("request not valid");
		}
		hotelService.createHotel(hotel);
	}
	
	@GetMapping("/getAll")
	public List<Hotel> getAllHotels() {
		
		return hotelService.getAllHotel();
		
	}
	
	@GetMapping("/id/{id}")
	public Hotel getHotelById(@PathVariable String id) {
		
		return hotelService.getHotelById(id);
	}
	@DeleteMapping("/remove/id/{id}")
	public void deleteHotelById(@PathVariable String id) {
		hotelService.deleteHotelById(id);
	}
	
	@PutMapping("/update")
	public void updateHotel(@RequestBody Hotel hotel) {
		hotelService.updateHotel(hotel);
	}
	
}
