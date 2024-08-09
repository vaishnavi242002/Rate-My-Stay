




package com.example.website.communicator;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.website.exception.HttpRatingServiceNotFound;

@Service
public class RatingServiceCommunicator {

	public final RestTemplate restTemplate;
    @Autowired
	public RatingServiceCommunicator(RestTemplateBuilder restTemplateBuilder) {
		
		this.restTemplate = restTemplateBuilder.build();
	}
    
    public long getRating(String id) {
    	
    	String url="http://localhost:8081/rating/id/";
    	//respone the all body
//    	ResponseEntity<Long> response=restTemplate.getForEntity(url+id,Long.class);
//    	return response.getBody(); 
    	//response only the object
//    	Long ratingRespone=restTemplate.getForObject(url+id,Long.class);
    	Long ratingResponse=restTemplate.getForObject(url+id, Long.class);
    	return ratingResponse;
    	//by exchange method
//    	 ResponseEntity<Object> response= restTemplate.exchange(url+id, HttpMethod.GET,null,Object.class);
//         Long longratingrespone=(Long)response.getBody();
//         return longratingrespone;
    }

	public void addRating(Map<String, Long> ratingMap) {
		// TODO Auto-generated method stub
		String url="http://localhost:8081/rating/add";
//		restTemplate.postForObject(url, ratingMap, Object.class);
		//Exchange Method
		HttpEntity<Map<String, Long>> requestEntity=new HttpEntity<>(ratingMap);
		restTemplate.exchange(url, HttpMethod.POST,requestEntity,Object.class);
		
	}
	
	public void updateRating(Map<String,Long> ratingMap) {
		String url="http://localhost:8081/rating/update";
		HttpEntity<Map<String,Long>> requestEntity=new HttpEntity<Map<String,Long>>(ratingMap);
		restTemplate.exchange(url, HttpMethod.PUT,requestEntity,Object.class);
	}

	public void deleteRating(String id) {
//		String url="http://localhost:8081/rating/id/";
		String url="http://localhost:8081/rating/remove/id/";
		try {
		restTemplate.exchange(url+id, HttpMethod.DELETE,null,Object.class);
		}
		catch(HttpClientErrorException e) {
			throw new HttpRatingServiceNotFound(HttpStatusCode.valueOf(HttpStatus.NOT_FOUND.value()));
		}
	}

	
	
}
