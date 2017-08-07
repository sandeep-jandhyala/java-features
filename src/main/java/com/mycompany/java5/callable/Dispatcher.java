/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.java5.callable;

import com.mycompany.dto.Letter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author jan_s
 */
public class Dispatcher {
    
    public static void main(String args[]) throws InterruptedException, ExecutionException, TimeoutException{
        
        List<Letter> letterList = letterBuilder();
        List<Future<String>> futureList = new ArrayList<Future<String>>();

        ExecutorService e = Executors.newFixedThreadPool(5);        
        
        for(Letter l:letterList)
        {
        Future<String> f= e.submit(new Printer(l));
        futureList.add(f);
        }
        
        for(Future f:futureList)
        {
         f.get(2000,TimeUnit.MILLISECONDS);
         System.out.println(f.isDone());
        }
        
        e.shutdown();
    }

    private static List<Letter> letterBuilder() {
        
        List<Letter> letterList = new ArrayList<Letter>();
    
         Letter l1 = new Letter("LTR001",new HashMap());
         Letter l2 = new Letter("LTR002",new HashMap());
         Letter l3 = new Letter("LTR005",new HashMap());
         Letter l4 = new Letter("LTR006",new HashMap());
         Letter l5 = new Letter("LTR005",new HashMap());
         Letter l6 = new Letter("LTR004",new HashMap());
         Letter l7 = new Letter("LTR005",new HashMap());
         Letter l8 = new Letter("LTR001",new HashMap());
         Letter l9 = new Letter("LTR002",new HashMap());
         Letter l10 = new Letter("LTR001",new HashMap());
         
         
         letterList.add(l1);
         letterList.add(l2);
         letterList.add(l3);
letterList.add(l4);
letterList.add(l5);
letterList.add(l6);
letterList.add(l7);
letterList.add(l8);
letterList.add(l9);
letterList.add(l10);

                           
         return letterList; 

    }
    
}
