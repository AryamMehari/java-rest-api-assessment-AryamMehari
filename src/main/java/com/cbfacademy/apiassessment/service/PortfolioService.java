package com.cbfacademy.apiassessment.service;

import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.model.PortfolioData;
import com.cbfacademy.apiassessment.model.PortfolioData.Portfolio;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;

@Service
public class PortfolioService implements PortfolioServiceOperations {

    // Define the path to the JSON file
    private final String jsonFilePath = "/Users/aryammehari/java-rest-api-assessment-AryamMehari/src/main/java/com/cbfacademy/apiassessment/DataStorage/portfolioData.json";

    // Implement methods from the PortfolioFileOperations interface

    @Override
    // Deserialises the data in the JSON file to a list of objects to be read
    public List<PortfolioData.Portfolio> readPortfoliosFromFile(String jsonFilePath) throws Exception {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<PortfolioData.Portfolio>>() {
        }.getType();
        return gson.fromJson(new FileReader(jsonFilePath), listType);
    }

    @Override
    // Write out the data from the JSON file and serialise the portfolios list into JSON format
    public void writePortfoliosToFile(List<PortfolioData.Portfolio> portfolios, String jsonFilePath) throws Exception {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(jsonFilePath)) {
            gson.toJson(portfolios, writer);
        }
    }

    // This method gets all portfolios written in the JSON file
    public List<PortfolioData.Portfolio> getAllPortfolios() {
        try {
            //uses method from the interface to read portfolios from the JSON file
            List<PortfolioData.Portfolio> portfolios = readPortfoliosFromFile(jsonFilePath);

            // Sort the portfolios by ID
            portfolios.sort(Comparator.comparingInt(PortfolioData.Portfolio::getId));

            return portfolios;
        } catch (Exception e) {
            // Handle exceptions, such as file not found
            e.printStackTrace();
            System.err.println("Error loading portfolios: " + e.getMessage());
            return null;
        }
    }

    // This method takes an id parameter and returns the corresponding portfolio
    public Portfolio getPortfolioById(int id) {

        // Converting list into a stream and filters to find the portfolio with a
        // specific id and takes the first instance of the specific id
        List<PortfolioData.Portfolio> portfolios = getAllPortfolios();
        return portfolios.stream()
                .filter(portfolio -> portfolio.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // This method adds a new portfolio to the existing list of portfolios
    public void addPortfolio(PortfolioData.Portfolio newPortfolio) {
        try {
            List<PortfolioData.Portfolio> existingPortfolios = readPortfoliosFromFile(jsonFilePath);

            // Add the new portfolio to the list
            existingPortfolios.add(newPortfolio);

            // Write the updated list back to the file using the method from the interface
            writePortfoliosToFile(existingPortfolios, jsonFilePath);

        } catch (Exception e) {
            // Handle exceptions, such as file not found
            e.printStackTrace();
            System.err.println("Error adding portfolio: " + e.getMessage());
        }

    }

    // This method reads then updates the portfolio specified by id from the JSON
    // file
    public void updatePortfolio(int id, PortfolioData.Portfolio updatedPortfolio) {
        try {
            List<PortfolioData.Portfolio> existingPortfolios = readPortfoliosFromFile(jsonFilePath);

            // Find the portfolio with the specified id and update its information
            for (int i = 0; i < existingPortfolios.size(); i++) {
                PortfolioData.Portfolio portfolio = existingPortfolios.get(i);
                if (portfolio.getId() == id) {
                    existingPortfolios.set(i, updatedPortfolio);
                    break;
                }
            }

            // Write the updated list back to the file using the method from the interface
            writePortfoliosToFile(existingPortfolios, jsonFilePath);

        } catch (Exception e) {
            // Handle exceptions, such as file not found
            e.printStackTrace();
            System.err.println("Error updating portfolio: " + e.getMessage());
        }
    }

    // This method will delete the portfolio specified by id from the JSON file
    public void deletePortfolio(int id) {
        try {
            // Define the path to the JSON file
            String jsonFilePath = "/Users/aryammehari/java-rest-api-assessment-AryamMehari/src/main/java/com/cbfacademy/apiassessment/DataStorage/portfolioData.json";

            // Create a Gson instance
            Gson gson = new Gson();

            // Read existing JSON data from the file
            Type listType = new TypeToken<List<PortfolioData.Portfolio>>() {
            }.getType();
            List<PortfolioData.Portfolio> existingPortfolios = gson.fromJson(new FileReader(jsonFilePath), listType);

            // Remove the portfolio with the specified ID
            existingPortfolios.removeIf(portfolio -> portfolio.getId() == id);

            // Write the updated list back to the file
            try (FileWriter writer = new FileWriter(jsonFilePath)) {
                gson.toJson(existingPortfolios, writer);
            }

        } catch (Exception e) {
            // Handle exceptions, such as file not found or JSON parsing errors
            e.printStackTrace();
            System.err.println("Error deleting portfolio: " + e.getMessage());
        }
    }
}
