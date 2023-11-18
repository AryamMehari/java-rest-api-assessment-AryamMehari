package com.cbfacademy.apiassessment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cbfacademy.apiassessment.model.PortfolioData;
import com.cbfacademy.apiassessment.service.PortfolioService;

@SpringBootApplication
@ComponentScan(basePackages = "com.cbfacademy.apiassessment")
@RestController
@ResponseBody
public class ApiController {

    public static void main(String[] args) {
        SpringApplication.run(ApiController.class, args);
    }

    @RestController
    public class PortfolioController {

        private final PortfolioService portfolioService;

        // Injecting a PortfolioService instance into the controller
        @Autowired
        public PortfolioController(PortfolioService portfolioService) {
            this.portfolioService = portfolioService;
        }

        // This code represents an endpoint which returns a list of portfolios using the
        // getAllPortfolios method
        @GetMapping("/api/portfolios")
        public List<PortfolioData.Portfolio> getAllPortfolios() {
            return portfolioService.getAllPortfolios();
        }

        // This endpoint returns a portfolio by the specified ID in the URL
        @GetMapping("/api/portfolios/{id}")
        public ResponseEntity<PortfolioData.Portfolio> getPortfolioById(@PathVariable int id) {
            // The getPortfoliobyId method is called to retrieve a portfolio by a specified
            // id; an error message is returned if the portfolio is not found
            PortfolioData.Portfolio portfolio = portfolioService.getPortfolioById(id);

            if (portfolio != null) {
                return new ResponseEntity<>(portfolio, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        // This endpoint handles a post request to create a new portfolio, it expects a
        // portfolio which follows the structure specified in the PortfolioData class.
        // This method returns a response based on the success or failure of adding a
        // new portfolio
        @PostMapping("/api/new/portfolio")
        public ResponseEntity<String> addPortfolio(@RequestBody PortfolioData.Portfolio newPortfolio) {
            try {
                portfolioService.addPortfolio(newPortfolio);
                return new ResponseEntity<>("Portfolio added successfully", HttpStatus.CREATED);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return new ResponseEntity<>("Error adding portfolio: " + e.getMessage(), HttpStatus.BAD_REQUEST);
            }

        }

    }

}