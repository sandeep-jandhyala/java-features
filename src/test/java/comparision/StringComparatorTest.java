/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparision;

import com.mycompany.comparision.StringComparator;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jan_s
 */
public class StringComparatorTest {
    
    String s1;
    String s2;
    
    
   
    
     @Test
    void compare_EqualityOperatorTest() {
        
        s1 = "RED";
        s2 = "BLUE";

        assertFalse(StringComparator.compare_EqualityOperator(s1, s2));
        assertTrue(StringComparator.compare_EqualityOperator("red", "red"));
      
    }
    
     @Test
    void compare_EqualsMethodTest() {
        
       
        assertTrue(StringComparator.compare_EqualsMethod("red", "red"));
        
        assertTrue(StringComparator.compare_EqualityOperator("red", "red"));

        s1 = "RED";
        s2 = "BLUE";
        
        assertFalse(StringComparator.compare_EqualityOperator(s1, s2));
        
         s2 = "RED";
        
        assertTrue(StringComparator.compare_EqualityOperator(s1, s2));
        
        assertTrue(StringComparator.compare_EqualsMethod(s1, s2));

      
    }
    
    
    
}
