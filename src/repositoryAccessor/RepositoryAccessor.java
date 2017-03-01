package repositoryAccessor;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE_NEW;
import static java.nio.file.StandardOpenOption.WRITE;
import java.util.ArrayList;
import java.util.List;

/**
 * This class serves as a wrapper for the file operations provided by Java.
 * 
 * This is done to abstract away the work done to access files. This class is 
 * used to access a repository. It allows the user to read and write contents 
 * from files in the repository. 
 * <p>
 * The user is freed from the work of <strong>resource handling</strong> as 
 * it is taken care by the implementation itself.
 * </p>
 * @author Kaartic Sivaraam
 */
public class RepositoryAccessor {

    /**
     * 
     * @param base The base path of the repository is to be specified in the
     * constructor to aid future access relative to that path. All methods 
     * consider the path provided are done relative to this path.
     * 
     * @throws InvalidRepositoryOperation The constructor throws when the given
     * base path does not exist.
     */
    public RepositoryAccessor(String base) throws InvalidRepositoryOperation {
        basePath = Paths.get(base);
	if(Files.notExists(basePath)) {
		throw new InvalidRepositoryOperation ("The Base Path does not exist");
	}
    }
	
    /**
     * This method reads contents from the <code> source </code> and returns the
     * contents as a <code> StringBuilder </code>.
     * 
     * @param source It is the path of the source file relative to the {@link #basePath}
     * @return <code> StringBuilder </code> The contents of the file are returned as 
     * a <code> StringBuilder </code>.
     * @throws InvalidRepositoryOperation This method throws this class when,
     * <ul>
     *         <li> the file does not exist
     *         <li> an <code> IOException </code> occurs during a file operation
     * </ul>
     */
    public StringBuilder readFromFile(String source) throws InvalidRepositoryOperation {
        Path sourcePath = Paths.get(basePath.toString(), source);
	if(Files.notExists(sourcePath))
            throw new InvalidRepositoryOperation ("File does not exist");
	
        StringBuilder fileContents = new StringBuilder();
	
        try(InputStream in = Files.newInputStream(sourcePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));) {
                String line;
                while((line = reader.readLine()) != null) {
                    fileContents.append(line+"\n");
                }        
        }  
        catch (IOException ex) {
            throw new InvalidRepositoryOperation ("IOException when trying to write to file\n"+ex.getMessage());
        }
       
        return fileContents;
    }
    
    /**
     * This method writes the contents of the provided <code> String </code>, to the 
     * <code> destination </code> which is assumed to, not exist before invocation.
     * 
     * @param destination The path of the destination relative to {@link basePath}
     * @param contentsToWrite The <code> String </code>containing the contents to be
     * written to the file.
     * 
     * @throws InvalidRepositoryOperation This method throws when,
     * <ul>
     *     <li> the Parent of the file doesn't exist
     *     <li> file does exists previously
     *     <li> an <code> IOException </code> occurs during File write operation
     * </ul>
     */
    public void writeToNewFile(String destination, String contentsToWrite) throws InvalidRepositoryOperation {
        Path destinationPath = Paths.get(basePath.toString(), destination);
        
        if(Files.notExists(destinationPath.getParent())) {
            throw new InvalidRepositoryOperation ("Parent of file does not exist");
        }
                
        byte[] contentsAsBytes = contentsToWrite.getBytes();
        
	try ( OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(destinationPath, CREATE_NEW))) {
            out.write(contentsAsBytes, 0, contentsAsBytes.length);
        }
        catch (IOException ex) {
            throw new InvalidRepositoryOperation ("IOException when trying to write to file\n"+ex.getMessage());
        }
    }
    
    /**
     * This method writes the contents of the provided <code> String </code>, to the 
     * <code> destination </code> which is assumed to, exist before invocation.
     * 
     * @param destination The path of the destination relative to {@link basePath}
     * @param contentsToWrite The <code> String </code> containing the contents to be
     * written to the file.
     * 
     * @throws InvalidRepositoryOperation This method throws when,
     * <ul>
     *         <li> the Parent of the file doesn't exist
     *         <li> an <code> IOException </code> occurs during File write operation
     * </ul>
     */
     public void appendToFile(String destination, String contentsToWrite) throws InvalidRepositoryOperation {
        Path destinationPath = Paths.get(basePath.toString(), destination);
        
        if(Files.notExists(destinationPath.getParent())) {
            throw new InvalidRepositoryOperation ("Parent of file does not exist");
        }
        
        byte[] contentsAsBytes = contentsToWrite.getBytes();
        
	try ( OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(destinationPath, WRITE, APPEND))) {
            out.write(contentsAsBytes, 0, contentsAsBytes.length);
        }
        catch (IOException ex) {
            throw new InvalidRepositoryOperation ("IOException when trying to write to file\n" + ex.getMessage());
        }
    }
    /**
     * The member that stores the base path of the repository
     */
    private final Path basePath;
	
}
