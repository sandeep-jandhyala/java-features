/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comparision;

import com.mycompany.dto.Employee;
import java.util.Comparator;

/**
 *
 * @author jan_s
 */
public class EmployeeIdSorter implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        
        int i = (int) (e1.getEmpId() - e2.getEmpId());
        return i;
    }
    
}
