/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositoryAccessor;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author unique
 */
public class InvalidRepositoryOperationTest {
    
    public InvalidRepositoryOperationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getMessage method, of class InvalidRepositoryOperation.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        InvalidRepositoryOperation instance = new InvalidRepositoryOperation();
        String expResult = "Unknown reason";
        String result = instance.getMessage();
        assertEquals(expResult, result);
    }
    
}
