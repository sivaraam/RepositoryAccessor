/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositoryAccessor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author unique
 */
public class RepositoryAccessorTest {
    public static void main(String[] args) {
        try {
            RepositoryAccessor testInstance = new RepositoryAccessor("/home/unique");
            Object[] fileContents = testInstance.readContentsFromFile("test");
            for(Object line : fileContents) {
                System.out.println(line);
            }
        } catch (InvalidRepositoryOperation ex) {
            Logger.getLogger(RepositoryAccessorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
