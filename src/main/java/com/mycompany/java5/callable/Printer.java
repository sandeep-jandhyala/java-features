/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.java5.callable;

import com.mycompany.dto.Letter;
import java.util.concurrent.Callable;

/**
 *
 * @author jan_s
 */
public class Printer implements Callable<String>{
    
    
    Letter l;
    
    public Printer(Letter l){
        this.l = l;
    }

    @Override
    public String call() throws InterruptedException{
        
        System.out.println("Thread " +Thread.currentThread().getName() +" Printing Letter " +l.getTemplate());
        Thread.sleep(2000);
        return "Success";
        
      
    }
    
}
