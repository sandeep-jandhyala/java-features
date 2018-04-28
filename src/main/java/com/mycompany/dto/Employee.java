/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

/**
 *
 * @author jan_s
 */
public class Employee {
    
    long empId;
    
    String employeeName;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    
  public void setEmpId(long id) {
        this.empId=id;
    }
   
   public long getEmpId() {
       return empId;
   }
    
   
   @Override
   public boolean equals(Object o){
       
       Employee e = (Employee) o;
       
       if(e.empId==this.empId)
           return true;
       
       return false;
       
   }
   
   @Override
   public int hashCode(){
     
       int hash=8;
       int empId = (int) this.empId;
       hash = 7*hash+empId;
      return hash;
       
   }
    
}
