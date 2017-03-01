/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositoryAccessor;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author unique
 */
public class RepositoryAccessorTest {
    
    public RepositoryAccessorTest() {      
        try {
            // TODO: Change the path to a relative one
            instance = new RepositoryAccessor("/mnt/8EC817CBC817B087/source/netbeans/RepositoryAccessor/test/testFiles");
        } catch (InvalidRepositoryOperation ex) {
            Logger.getLogger(RepositoryAccessorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of writeToNewFile method, of class RepositoryAccessor.
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteToNewFile() throws Exception {
        Random randomGenerator = new Random();
        Integer randomVal = randomGenerator.nextInt();
        System.out.println("writeToNewFile");
        String destination = "test"+randomVal.toString();
        String contentsToWrite = "Hello World";
        instance.writeToNewFile(destination, contentsToWrite);
       
    }

    /**
     * Test of appendToFile method, of class RepositoryAccessor.
     * @throws java.lang.Exception
     */
    @Test
    public void testAppendToFile() throws Exception {
        System.out.println("appendToFile");
        String destination = "appendFile";
        String contentsToWrite = "test12345";
        instance.appendToFile(destination, contentsToWrite);
    }
    
    /**
     * Test of readFromFile method, of class RepositoryAccessor.
     * @throws java.lang.Exception
     */
    @Test
    public void testReadFromFile() throws Exception {
        System.out.println("readFromFile");
        String source = "readFile";
        String expResult = "Hello World\n\tHello\t1234\n";
        System.out.println(expResult);
        StringBuilder result = instance.readFromFile(source);
        System.out.println(result);
        assertEquals(expResult, result.toString());
               
    }
    
    RepositoryAccessor instance;
}
