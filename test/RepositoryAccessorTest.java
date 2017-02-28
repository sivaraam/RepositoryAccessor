/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.logging.Level;
import java.util.logging.Logger;
import repositoryAccessor.InvalidRepositoryOperation;
import repositoryAccessor.RepositoryAccessor;

/**
 *
 * @author unique
 */
public class RepositoryAccessorTest {
    public static void main(String[] args) {
        try {
            RepositoryAccessor testInstance = new RepositoryAccessor("/home/unique");
            
            String[] testArray = { "Hello", "World", "!@#$%^&*()_+" };
            
            for(String testLine : testArray)
                testInstance.writeStringToFile("testFile", testLine+"\n");
            
            String[] fileContents = testInstance.readContentsFromFile("testFile");
            
            int i;
            for(i=0; i<fileContents.length; i++) {
                if(!fileContents[i].equals(testArray[i])) {
                    System.out.println("Test failed");
                    break;
                }
            }
            if(i == fileContents.length) {
                System.out.println("Test passed");
            }
            
        } catch (InvalidRepositoryOperation ex) {
            Logger.getLogger(RepositoryAccessorTest.class.getName()).log(Level.SEVERE, ex.what());
        }
    }
    
}
