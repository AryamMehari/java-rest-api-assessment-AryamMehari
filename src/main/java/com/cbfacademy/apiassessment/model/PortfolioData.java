package com.cbfacademy.apiassessment.model;

import java.util.List;

//PortfolioData class represents each portfolio with its id, name, description, and a list of stocks.
public class PortfolioData {

    private List<Portfolio> portfolios;

    public List<Portfolio> getPortfolios() {
        return portfolios;
    }

    public static class Portfolio {
        private int id;
        private String name;
        private String description;
        private List<Stocks> stocks;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
        public List<Stocks> getStocks() {
            return stocks;
        }

        public void setStocks(List<Stocks> stocks) {
            this.stocks = stocks;
        }

    }
}

    
