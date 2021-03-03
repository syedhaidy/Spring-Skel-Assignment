package com.cepheid.cloud.skel.client;



import org.springframework.web.client.RestTemplate;

import com.cepheid.cloud.skel.model.Item;

public class Tester1001 {
	public static final String REST_SERVICE_URI = "http://localhost:9443/app/api/1.0/items/";

	// GET 
	private static void getItemAddedOnDescription() {
		System.out.println("Testing Created Description with one to many Items----------");
		RestTemplate restTemplate = new RestTemplate();
		//Placing Request and getting response
		Item itm = restTemplate.getForObject(REST_SERVICE_URI + "5",Item.class);
		System.out.println(itm);
	}


	public static void main(String args[]) {
		getItemAddedOnDescription();
		
		
	}
}

