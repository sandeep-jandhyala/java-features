/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import java.util.Map;

/**
 *
 * @author jan_s
 */
public class Letter {
    
    String template; 
    
    Map letterVariables;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Map getLetterVariables() {
        return letterVariables;
    }

    public void setLetterVariables(Map letterVariables) {
        this.letterVariables = letterVariables;
    }

    public Letter(String template, Map letterVariables) {
        this.template = template;
        this.letterVariables = letterVariables;
    }
    
    
    
}
