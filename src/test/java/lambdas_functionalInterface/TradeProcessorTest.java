/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdas_functionalInterface;

import com.mycompany.java8.dto.TradeOrder;
import com.mycompany.java8.lambdas_functionalinterface.TradeProcessor;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.UUID;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jan_s
 */
public class TradeProcessorTest {

    private static TradeProcessor tp;
    private TradeOrder buyToHugeTransaction;
    private TradeOrder buyToPastTime;
    private TradeOrder sellTo;
    private TradeOrder buyTo;
    private TradeOrder sellToInvalidQuantity;

    static LocalDateTime validDate = LocalDateTime.of(2017, Month.MARCH, 29, 15, 55);
    static LocalDateTime invalidDate = LocalDateTime.of(2017, Month.MARCH, 29, 16, 55);

    @BeforeAll
    static void initializeProcessor() {
        tp = new TradeProcessor();

    }
    
     @Test
    void processTrade_Exception_InvalidQuantity() {
        sellToInvalidQuantity = new TradeOrder(UUID.randomUUID(), "BUY", "GOOG", 125.4, 0, validDate);
       assertThrows(IllegalArgumentException.class,() -> tp.processTradeOrder(sellToInvalidQuantity));
    }

    @Test
    void processTrade_Success() {
        buyTo = new TradeOrder(UUID.randomUUID(), "BUY", "GOOG", 125.4, 50, validDate);
        tp.processTradeOrder(buyTo);
        assertAll("counters", () -> {
            assertEquals(1, TradeProcessor.getTradesSubmittedCounter());
            assertEquals(1, TradeProcessor.getTradesProcessedCounter());
        });
    }

    @Test
    void processTrade_Skipped_Time() {
        buyToPastTime = new TradeOrder(UUID.randomUUID(), "BUY", "GOOG", 125.4, 50, invalidDate);
        tp.processTradeOrder(buyToPastTime);
        assertEquals(1, TradeProcessor.getTradesSubmittedCounter());
        assertEquals(0, TradeProcessor.getTradesProcessedCounter());
    }

    @Test
    void processTrade_Skipped_HugeTransaction() {
        buyToHugeTransaction = new TradeOrder(UUID.randomUUID(), "BUY", "GOOG", 125.4, 5000, validDate);
        tp.processTradeOrder(buyToHugeTransaction);
        assertEquals(1, TradeProcessor.getTradesSubmittedCounter());
        assertEquals(0, TradeProcessor.getTradesProcessedCounter());
    }

    @Test
    void processTrade_Success_Mutiple() {
        buyTo = new TradeOrder(UUID.randomUUID(), "BUY", "GOOG", 125.4, 50, validDate);
        tp.processTradeOrder(buyTo);
        assertEquals(1, TradeProcessor.getTradesSubmittedCounter());
        assertEquals(1, TradeProcessor.getTradesProcessedCounter());
        sellTo = new TradeOrder(UUID.randomUUID(), "SELL", "GOOG", 125.4, 50, validDate);
        tp.processTradeOrder(sellTo);
        assertEquals(2, TradeProcessor.getTradesSubmittedCounter());
        assertEquals(2, TradeProcessor.getTradesProcessedCounter());
    }

    @AfterEach
    void resetCounters() {
        TradeProcessor.tradesProcessedCounter = 0;
        TradeProcessor.tradesSkippedCounter = 0;
        TradeProcessor.tradesSubmittedCounter = 0;
    }

    @AfterAll
    static void tearDownAll() {
        tp = null;
    }

}
