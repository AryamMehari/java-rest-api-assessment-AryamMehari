package com.cbfacademy.apiassessment.service;

import java.util.List;

import com.cbfacademy.apiassessment.model.PortfolioData;

// Create an interface for file operations
public interface PortfolioServiceOperations {

    List<PortfolioData.Portfolio> readPortfoliosFromFile(String jsonFilePath) throws Exception;

    void writePortfoliosToFile(List<PortfolioData.Portfolio> portfolios, String jsonFilePath) throws Exception;
}
