package com.cbfacademy.apiassessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Description;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.cbfacademy.apiassessment.Controller.ApiController;
import com.cbfacademy.apiassessment.model.PortfolioData;

import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = ApiController.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppTests {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate restTemplate;

	@BeforeEach
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port);
	}

	@Test
	@Description("/api/portfolios endpoint returns all portfolios from the JSON file")
	public void getAllPortfolios_ReturnsAllPortfolios() {
		ResponseEntity<List<PortfolioData.Portfolio>> response = restTemplate.exchange(
				base.toString() + "/api/portfolios",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<PortfolioData.Portfolio>>() {
				});

		List<PortfolioData.Portfolio> portfolios = response.getBody();
		// Check if portfolios is not null before accessing its properties
		assertNotNull(portfolios);
		// Check the number of portfolios in the JSON file
		assertEquals(3, portfolios.size());
	}

}
