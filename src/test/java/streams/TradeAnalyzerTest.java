/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streams;

import com.mycompany.java8.dto.TradeOrder;
import com.mycompany.java8.lambdas_functionalinterface.TradeProcessor;
import com.mycompany.java8.streams.TradeAnalyzer;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jan_s
 */
public class TradeAnalyzerTest {
    
     private static TradeAnalyzer ta;
    private static TradeOrder buyToHugeTransaction;
    private static TradeOrder buyToPastTime;
    private static TradeOrder sellTo;
    private static TradeOrder buyTo;
    private static TradeOrder sellToInvalidQuantity;
    private static List<TradeOrder> trades= new ArrayList();

    static LocalDateTime validDate = LocalDateTime.of(2017, Month.MARCH, 29, 15, 55);
    static LocalDateTime invalidDate = LocalDateTime.of(2017, Month.MARCH, 29, 16, 55);

    @BeforeAll
    static void initializeProcessor() {
        ta = new TradeAnalyzer();
        sellToInvalidQuantity = new TradeOrder(UUID.randomUUID(), "BUY", "GOOG", 125.4, 0, validDate);
        buyTo = new TradeOrder(UUID.randomUUID(), "BUY", "GOOG", 125.4, 50, validDate);
        buyToPastTime = new TradeOrder(UUID.randomUUID(), "BUY", "GOOG", 125.4, 50, invalidDate);
        buyToHugeTransaction = new TradeOrder(UUID.randomUUID(), "BUY", "GOOG", 125.4, 5000, validDate);
        sellTo = new TradeOrder(UUID.randomUUID(), "SELL", "GOOG", 125.4, 50, validDate);
        trades.add(sellTo);
        trades.add(buyTo);
        trades.add(buyToPastTime);
        trades.add(buyToHugeTransaction);
        trades.add(sellToInvalidQuantity);
        
    }
    
    @Test
    void findAnyHeavyTransaction(){
        assertTrue(ta.findAnyHeavyTransactionTrade(trades));
    }
    
    @Test
    void getLateTradeCount(){
        assertEquals(1,ta.getLateTradeCount(trades));
    }
    
        
}
