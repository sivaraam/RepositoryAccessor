/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositoryaccessor;

import repositoryaccessor.RepositoryAccessor;
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
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of readContentsFromFile method, of class RepositoryAccessor.
     */
    @Test
    public void testReadContentsFromFile() throws Exception {
        System.out.println("readContentsFromFile");
        String source = "testFile";
        RepositoryAccessor instance = new RepositoryAccessor("/home/unique");
        String[] expResult = null;
        String[] result = instance.readContentsFromFile(source);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeStringToFile method, of class RepositoryAccessor.
     */
    @Test
    public void testWriteStringToFile() throws Exception {
        System.out.println("writeStringToFile");
        String destination = "";
        String contentsToWrite = "";
        RepositoryAccessor instance = null;
        instance.writeStringToFile(destination, contentsToWrite);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
