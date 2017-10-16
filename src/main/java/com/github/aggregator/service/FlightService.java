package com.github.aggregator.service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class FlightService {

	public String findFlight() {
		try {
			TimeUnit.SECONDS.sleep(2l);
			if (ThreadLocalRandom.current().nextBoolean()) {
				throw new InterruptedException("Business error");
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return "CYUL-CYVR";
	}
}
