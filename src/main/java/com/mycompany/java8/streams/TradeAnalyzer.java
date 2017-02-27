/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.java8.streams;

import com.mycompany.java8.dto.TradeOrder;
import java.util.List;
import java.util.UUID;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author jan_s
 */
public class TradeAnalyzer {
    
    
    public List<TradeOrder> filterHeavyTransactionTrades(List<TradeOrder> trades)
    {
        return trades.stream().filter(t -> t.getQuantity()*t.getStockUnitPrice() > 100000).collect(toList());
    }
    
    
     public boolean findAnyHeavyTransactionTrade(List<TradeOrder> trades)
    {
        
        return trades.stream().filter(t -> t.getQuantity()*t.getStockUnitPrice() > 100000).findAny().isPresent();
        
    }
     
      public List<UUID> getHeavyTransactionTradeIds(List<TradeOrder> trades)
    {
        
        return trades.stream().filter(t -> t.getQuantity()*t.getStockUnitPrice() > 100000)
                              .map(t -> t.getTradeId()).collect(toList());
        
    }
      
      
      public long getLateTradeCount(List<TradeOrder> trades)
    {
        
        return trades.stream().filter(t -> t.getOrderTime().getHour() >= 16).count();
                              
        
    }
}
