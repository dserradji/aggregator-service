package com.github.aggregator.api;

import static java.util.concurrent.CompletableFuture.supplyAsync;

import java.util.concurrent.Future;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.aggregator.service.FlightService;
import com.github.aggregator.service.HotelService;

@RestController
public class AggregatorController {
	
	private FlightService flights;
	private HotelService hotels;
	
	public AggregatorController(FlightService flights, HotelService hotels) {
		this.flights = flights;
		this.hotels = hotels;
	}
	
	@GetMapping("/flights")
	public Future<String> findFlight() {
		
		return supplyAsync(() -> flights.findFlight());
	}
	
	@GetMapping("/hotels")
	public Future<String> findHotel() {
		
		return supplyAsync(() -> hotels.findHotel());
	}
	
	@GetMapping("/packages")
	public Future<String> findPackage() {
		
		return supplyAsync(() -> flights.findFlight())
				.thenCombineAsync(supplyAsync(() -> hotels.findHotel()), 
						(flight, hotel) -> String.format("%s@%s", flight, hotel));
	}

}
