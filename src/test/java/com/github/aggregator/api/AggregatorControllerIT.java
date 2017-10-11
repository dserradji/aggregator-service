package com.github.aggregator.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = { AggregatorController.class })
@ComponentScan(basePackages = { "com.github.aggregator" })
public class AggregatorControllerIT {

	@Autowired
	private MockMvc mvc;

	@Test
	public void shouldRetuenAPackage() throws Exception {

		mvc.perform(asyncDispatch(mvc.perform(get("/packages")).andReturn()))
			.andExpect(status().isOk())
			.andExpect(content().string("CYUL-CYVR@Downtown Hostel"));
	}
}
