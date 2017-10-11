package com.github.aggregator.api;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.ExecutionException;

import org.junit.Test;

import com.github.aggregator.service.FlightService;
import com.github.aggregator.service.HotelService;

public class AggregatorControllerTest {

	@Test
	public void shouldReturnAFlight() throws InterruptedException, ExecutionException {
		
		// Given
		AggregatorController controller = new AggregatorController(new FlightService(), new HotelService());
		
		// When
		String flight = controller.findFlight().get();
		
		// Then
		assertThat(flight, is(equalTo("CYUL-CYVR")));
	}

	@Test
	public void shouldReturnAHotel() throws InterruptedException, ExecutionException {
		
		// Given
		AggregatorController controller = new AggregatorController(new FlightService(), new HotelService());
		
		// When
		String hotel = controller.findHotel().get();
		
		// Then
		assertThat(hotel, is(equalTo("Downtown Hostel")));
	}

	@Test
	public void shouldReturnACombo() throws InterruptedException, ExecutionException {
		
		// Given
		AggregatorController controller = new AggregatorController(new FlightService(), new HotelService());
		
		// When
		String combo = controller.findPackage().get();
		
		// Then
		assertThat(combo, is(equalTo("CYUL-CYVR@Downtown Hostel")));
	}
}
