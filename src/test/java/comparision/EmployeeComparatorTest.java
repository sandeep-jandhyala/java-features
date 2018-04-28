/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparision;

import com.mycompany.comparision.EmployeeComparator;
import com.mycompany.comparision.EmployeeIdSorter;
import com.mycompany.comparision.EmployeeNameSorter;
import com.mycompany.comparision.StringComparator;
import com.mycompany.dto.Employee;
import com.mycompany.dto.TradeOrder;
import com.mycompany.java8.lambdas_functionalinterface.TradeProcessor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jan_s
 */
public class EmployeeComparatorTest {
    
    Employee e1 = new Employee();
    Employee e2 = new Employee();
    
    
  
    
     @Test
    void compare_EqualityOperatorTest() {
       
         
        e1.setEmpId(123);
        e2.setEmpId(456);
        
        assertFalse(EmployeeComparator.compare_EqualityOperator(e1, e2));
      
    }
    
     @Test
         void compare_EqualsMethodTest() {
        
        e1.setEmpId(123);
        e2.setEmpId(123);
        
        assertTrue(EmployeeComparator.compare_EqualsMethod(e1, e2));

      
    }
         
         @Test
         void sort_Method_Test() {
        
        e1.setEmpId(123);
        e1.setEmployeeName("Roger");
        e2.setEmpId(456);
        e2.setEmployeeName("Albert");
        List<Employee> elist = new ArrayList<Employee>();
        elist.add(e1);
        elist.add(e2);
        EmployeeIdSorter ec = new EmployeeIdSorter();
         EmployeeNameSorter eNameSorter = new EmployeeNameSorter();
        Collections.sort(elist, ec);
        
       assertEquals(elist.get(0).getEmpId(),123);
       
       Collections.sort(elist, eNameSorter);
       
      assertEquals(elist.get(0).getEmployeeName(),"Albert");
        
      
    }
         
          @Test
         void compare_HashMethod_Test() {
        
        e1.setEmpId(123);
        e2.setEmpId(123);
        
       assertEquals(EmployeeComparator.compare_HashMethod(e1, e2),"employee2");
      
    }
    
    
    
}
