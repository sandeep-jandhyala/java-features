/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comparision;

import com.mycompany.dto.Employee;
import java.util.HashMap;

/**
 *
 * @author jan_s
 */
public class EmployeeComparator {
    
      public static boolean compare_EqualityOperator(Employee s1, Employee s2)
    {
        return s1==s2;
    }
    
    
     public static boolean compare_EqualsMethod(Employee e1, Employee e2)
    {
        return e1.equals(e2);
    }
     
      public static String compare_HashMethod(Employee e1, Employee e2)
    {
        HashMap<Employee, String> hmap = new HashMap();
        
        hmap.put(e1,"employee1");
        hmap.put(e2,"employee2");
        
        return hmap.get(e1);
    }
    
    
}
