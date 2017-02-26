/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.java8.lambdas_functionalinterface;

import com.mycompany.java8.dto.TradeOrder;

/**
 *
 * @author jan_s
 */
@FunctionalInterface
public interface ITradeValidator {
    
    public boolean validateTrade(TradeOrder obj);
    
}
