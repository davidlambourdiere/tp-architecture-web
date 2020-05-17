package com.lifetech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		RestTemplate restTemplate = new RestTemplate();
		try {
		String result = restTemplate.getForObject("http://localhost:8080/api/position/insertPositionByStrap", String.class);
	}catch (HttpClientErrorException e){
			System.out.println(e.getMessage());
		}
	}

}
