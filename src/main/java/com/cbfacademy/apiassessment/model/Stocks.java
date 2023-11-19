package com.cbfacademy.apiassessment.model;

import com.fasterxml.jackson.annotation.JsonFormat;

// Stocks class represents each stock with its symbol, name, quantity, and purchase price.
public class Stocks {
    
        private String symbol;
        private String name;
        private int quantity;
        private double unitPrice;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
        private String date;
    
        public String getSymbol() {
            return symbol;
        }
    
        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public int getQuantity() {
            return quantity;
        }
    
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    
        public double getUnitPrice() {
            return unitPrice;
        }
    
        public void setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }

