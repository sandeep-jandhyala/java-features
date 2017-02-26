/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.java8.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author jan_s
 */
public class TradeOrder {

    public UUID getTradeId() {
        return tradeId;
    }
    
    UUID tradeId;
    String orderType;
    String stockSymbol;
    double stockUnitPrice;
    int quantity;
    LocalDateTime orderTime;

    public TradeOrder(UUID tradeId, String orderType, String stockSymbol, double stockUnitPrice, int quantity, LocalDateTime orderTime) {
        this.tradeId = tradeId;
        this.orderType = orderType;
        this.stockSymbol = stockSymbol;
        this.stockUnitPrice = stockUnitPrice;
        this.quantity = quantity;
        this.orderTime = orderTime;
    }
    
    

    public String getOrderType() {
        return orderType;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public double getStockUnitPrice() {
        return stockUnitPrice;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public int getQuantity() {
        return quantity;
    }

   
    
    
}
