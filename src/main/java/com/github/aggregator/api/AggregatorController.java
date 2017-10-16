package com.github.aggregator.api;

import static java.util.concurrent.CompletableFuture.supplyAsync;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.aggregator.service.AggregatorService;
import com.github.aggregator.service.FlightService;
import com.github.aggregator.service.HotelService;

@RestController
public class AggregatorController {
	
	@Autowired
	private FlightService flights;
	
	@Autowired
	private HotelService hotels;
	
	@Autowired
	private AggregatorService aggregator;
	
	@GetMapping("/flights")
	public Future<String> findFlight() {
		
		return supplyAsync(() -> flights.findFlight());
	}
	
	@GetMapping("/hotels")
	public Future<String> findHotel() {
		
		return supplyAsync(() -> hotels.findHotel());
	}
	
	@GetMapping("/packages-async")
	public Future<String> findPackage() {
		
		return aggregator.findPackageAsync();
	}
	
	@GetMapping("/packages")
	public String findPackageSync() {
		
		return aggregator.findPackage();
	}

}
