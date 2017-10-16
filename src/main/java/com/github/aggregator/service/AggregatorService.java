package com.github.aggregator.service;

import static java.util.concurrent.CompletableFuture.supplyAsync;

import java.util.concurrent.Future;

public class AggregatorService {

	private FlightService flights;
	private HotelService hotels;

	public AggregatorService(FlightService flights, HotelService hotels) {
		this.flights = flights;
		this.hotels = hotels;
	}

	public String findPackage() {
		return String.format("%s@%s", flights.findFlight(), hotels.findHotel());
	}

	public Future<String> findPackageAsync() {

		return supplyAsync(() -> flights.findFlight())
				.thenCombineAsync(supplyAsync(() -> hotels.findHotel()),
						(flight, hotel) -> String.format("%s@%s", flight, hotel));
	}

}
