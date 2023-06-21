package com.cbfacademy.apiassessment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.ComponentScan;
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

        //Injecting a PortfolioService instance into the controller
        @Autowired
        public PortfolioController(PortfolioService portfolioService) {
            this.portfolioService = portfolioService;
        }
        
        //This code represents an endpoint which returns a list of portfolios using the getAllPortfolios method
        @GetMapping("/api/portfolios")
        public List<PortfolioData.Portfolio> getAllPortfolios() {
            return portfolioService.getAllPortfolios();
        }

    }
}