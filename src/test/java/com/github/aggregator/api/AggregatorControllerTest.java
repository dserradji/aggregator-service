package com.github.aggregator.api;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.github.aggregator.service.AggregatorService;
import com.github.aggregator.service.FlightService;
import com.github.aggregator.service.HotelService;

@RunWith(MockitoJUnitRunner.class)
public class AggregatorControllerTest {
	
	@Mock
	private FlightService flights;
	
	@Mock
	private HotelService hotels;
	
	@Mock
	private AggregatorService aggregator;
	
	@InjectMocks
	private AggregatorController controller;
	
	@Before
	public void init() {
		when(flights.findFlight()).thenReturn("CYUL-CYVR");
		when(hotels.findHotel()).thenReturn("Downtown Hostel");
	}
	
	@Test
	public void shouldReturnAFlight() throws InterruptedException, ExecutionException {
		
		// Given
		
		// When
		String flight = controller.findFlight().get();
		
		// Then
		assertThat(flight, is(equalTo("CYUL-CYVR")));
	}

	@Test
	public void shouldReturnAHotel() throws InterruptedException, ExecutionException {
		
		// Given
		
		// When
		String hotel = controller.findHotel().get();
		
		// Then
		assertThat(hotel, is(equalTo("Downtown Hostel")));
	}

	@Test
	public void shouldReturnACombo() throws InterruptedException, ExecutionException {
		
		// Given
		
		// When
		String combo = controller.findPackage().get();
		
		// Then
		assertThat(combo, is(equalTo("CYUL-CYVR@Downtown Hostel")));
	}
}
