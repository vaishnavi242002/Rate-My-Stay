package com.example.website.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.website.service.RatingService;
@RestController
@RequestMapping("/rating")
public class RatingController {
//	@Autowired
	private final RatingService ratingService;
	@Autowired
	public RatingController(RatingService ratingService) {
		this.ratingService=ratingService;
	}
	@PostMapping(path="/add")
	public void addRating(@RequestBody Map<String,Long> hotelRatingMap) {
		ratingService.addRating(hotelRatingMap);
	}
	@PutMapping(path="/update")
	public void updateRating(@RequestBody Map<String, Long> hotelRatingMap) {
		ratingService.updateRating(hotelRatingMap);
	}
	@GetMapping(path="/id/{id}")
	public Long getRatingById(@PathVariable String id) {
		return ratingService.getRatingById(id);
	}
	@GetMapping(path="getAll")
	public Map<String,Long> getAllRating(){
		return ratingService.getAllRating();
	}
	@DeleteMapping(path="/id/{id}")
	public void deleteRating(@PathVariable String id) {
		ratingService.deleteRating(id);
	}
}
