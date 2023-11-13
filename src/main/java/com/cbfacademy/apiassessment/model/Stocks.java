package com.cbfacademy.apiassessment.model;

// Stocks class represents each stock with its symbol, name, quantity, and purchase price.
public class Stocks {
    
        private String symbol;
        private String name;
        private int quantity;
        private double purchasePrice;
    
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
    
        public double getPurchasePrice() {
            return purchasePrice;
        }
    
        public void setPurchasePrice(double purchasePrice) {
            this.purchasePrice = purchasePrice;
        }
    }

