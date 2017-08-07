/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.java8.lambdas_functionalinterface;

import com.mycompany.dto.TradeOrder;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author jan_s
 */
public class TradeProcessor {

    public static int tradesProcessedCounter;
    public static int tradesSkippedCounter;
    public static int tradesSubmittedCounter;

    // Custom Functional Interface
    ITradeValidator heavyTransactionLambda = t -> {
        return t.getStockUnitPrice() * t.getQuantity() > 100000;
    };

    // Java Built in Functional Interface
    Predicate<TradeOrder> timeCheckLambda = t -> t.getOrderTime().getHour() >= 16;
    

    Function<TradeOrder, Integer> processedTradeCounterLambda = t -> tradesProcessedCounter++;

    
    public boolean processTradeOrder(TradeOrder order) {

         auditTrade(order, (t) -> {
             if(t.getQuantity() <=0)
                 throw new IllegalArgumentException("Quantity is invalid");
            System.out.println("Trade # " + t.getTradeId() + " submitted for processing");
            tradesSubmittedCounter++;
        });
        
        if (heavyTransactionLambda.validateTrade(order) || timeCheckLambda.test(order)) {            
            // Huge Trades cannot be processed systemically, needs manual review
            return false;

        }

        //do the actual trade processing here 
        processedTradeCounterLambda.apply(order);

        return true;
    }

   
    private void auditTrade(TradeOrder t, Consumer<TradeOrder> c) {
        c.accept(t);
    }
    
     public static int getTradesProcessedCounter() {
        return tradesProcessedCounter;
    }

    public static int getTradesSkippedCounter() {
        return tradesSubmittedCounter-tradesProcessedCounter;
    }

    public static int getTradesSubmittedCounter() {
        return tradesSubmittedCounter;

    }
    
   


}
