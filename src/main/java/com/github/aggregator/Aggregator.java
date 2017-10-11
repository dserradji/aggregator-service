package com.github.aggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.aggregator.service.FlightService;
import com.github.aggregator.service.HotelService;

@SpringBootApplication
public class Aggregator {

	public static void main(String[] args) {
		SpringApplication.run(Aggregator.class, args);
	}

	@Bean
	public FlightService getFlightService() {
		return new FlightService();
	}
	
	@Bean
	public HotelService getHotelService() {
		return new HotelService();
	}
}
