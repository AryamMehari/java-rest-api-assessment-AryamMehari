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
import org.springframework.http.HttpStatus;
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
		// Make a GET request to the /api/portfolios endpoint
		ResponseEntity<List<PortfolioData.Portfolio>> response = restTemplate.exchange(
				base.toString() + "/api/portfolios",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<PortfolioData.Portfolio>>() {
				});

		// Validate the HTTP status code
		assertEquals(HttpStatus.OK, response.getStatusCode());

		// Validate that the response body is not null
		List<PortfolioData.Portfolio> portfolios = response.getBody();
		assertNotNull(portfolios);

		// Validate that the response contains the expected number of portfolios (adjust
		// as needed)
		// For example, if you know how many portfolios are in your JSON file, you can
		// check the size.
		// If the size is dynamic, you can check other properties to ensure correctness.
		assertEquals(2, portfolios.size());

		// Add additional validation as needed for the content of the portfolios
		// For example, check that specific portfolios or properties are present.
	}

	

	/*
	 * @Test
	 * 
	 * @Description("/greeting endpoint returns expected response for default name")
	 * public void greeting_ExpectedResponseWithDefaultName() {
	 * ResponseEntity<String> response = restTemplate.getForEntity(base.toString(),
	 * String.class);
	 * 
	 * assertEquals(200, response.getStatusCode().value());
	 * assertEquals("Hello World", response.getBody());
	 * }
	 * 
	 * @Test
	 * 
	 * @Description("/greeting endpoint returns expected response for specified name parameter"
	 * )
	 * public void greeting_ExpectedResponseWithNameParam() {
	 * ResponseEntity<String> response = restTemplate.getForEntity(base.toString() +
	 * "?name=John", String.class);
	 * 
	 * assertEquals(200, response.getStatusCode().value());
	 * assertEquals("Hello John", response.getBody());
	 * }
	 */
}
