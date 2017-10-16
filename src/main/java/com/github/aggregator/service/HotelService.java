package com.github.aggregator.service;

import java.util.concurrent.TimeUnit;

public class HotelService {

	public String findHotel() {
		try {
			TimeUnit.SECONDS.sleep(2l);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return "Downtown Hostel";
	}
}
