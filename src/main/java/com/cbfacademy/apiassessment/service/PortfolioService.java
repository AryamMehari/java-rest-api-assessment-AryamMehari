package com.cbfacademy.apiassessment.service;

import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.model.PortfolioData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class PortfolioService {

    public List<PortfolioData.Portfolio> getAllPortfolios() {
        try {
            // Define the path to the JSON file
            String jsonFilePath = "/Users/aryammehari/java-rest-api-assessment-AryamMehari/src/main/java/com/cbfacademy/apiassessment/DataStorage/portfolioData.json";

            // Create a Gson instance
            Gson gson = new Gson();

            // Read JSON data from the file and deserialize it into a list of portfolio objects
            Type listType = new TypeToken<List<PortfolioData.Portfolio>>() {}.getType();
            List<PortfolioData.Portfolio> portfolios = gson.fromJson(new FileReader(jsonFilePath), listType);

            return portfolios;
        } catch (Exception e) {
            // Handle exceptions, such as file not found
            e.printStackTrace();
            System.err.println("Error loading portfolios: " + e.getMessage());
            return null;
        }
    }
}