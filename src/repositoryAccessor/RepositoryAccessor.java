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
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kaartic
 * 
 * This class is used to access a repository.
 * It allows to read and write contents from files in the repository
 * 
 * This class serves as a wrapper for the file operations provided by Java.
 * This is done to abstract away the work done to access files.
 * 
 * 
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
     * This method reads contents from the {@code source} and returns the
     * contents as an array of {@code String}s.
     * 
     * @param source It is the path of the source file relative to the {@link #basePath}
     * @return {@code String[]} The contents of the file are returned as a {@code String} array,
     * with each line represented by an array element.
     * @throws {@code InvalidRepositoryOperation}This method throws this class when,
     *         1. the file does not exist
     *         2. an {@code IOException} occurs during a file operation
     */
    public String[] readContentsFromFile(String source) throws InvalidRepositoryOperation {
        Path sourcePath = Paths.get(basePath.toString(), source);
	if(Files.notExists(sourcePath))
            throw new InvalidRepositoryOperation ("File does not exist");
	
        List<String> lines = new ArrayList<>();
	
        try(InputStream in = Files.newInputStream(sourcePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));) {
                String line;
                while((line = reader.readLine()) != null) {
                    lines.add(line);
                }        
        }  
        catch (IOException ex) {
            throw new InvalidRepositoryOperation ("IOException when trying to write to file\n"+ex.getMessage());
        }
       
        return lines.toArray(new String[lines.size()]);
    }
    
    /**
     * This method writes the contents of the provided {@code String}, to the 
     * {@code destination}.
     * 
     * @param destination The path of the destination relative to {@link basePath}
     * @param contentsToWrite The {@code String} containing the contents to be
     * written to the file.
     * 
     * @throws InvalidRepositoryOperation This method throws when,
     *         1. the Parent of the file doesn't exist
     *         2. an {@code IOException} occurs during File write operation
     */
    public void writeStringToFile(String destination, String contentsToWrite) throws InvalidRepositoryOperation {
        Path destinationPath = Paths.get(basePath.toString(), destination);
        
        if(Files.notExists(destinationPath.getParent())) {
            throw new InvalidRepositoryOperation ("Parent of file does not exist");
        }
        byte[] contentsAsBytes = contentsToWrite.getBytes();
        
	try ( OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(destinationPath, CREATE, APPEND))) {
            out.write(contentsAsBytes, 0, contentsAsBytes.length);
        }
        catch (IOException ex) {
            throw new InvalidRepositoryOperation ("IOException when trying to write to file\n"+ex.getMessage());
        }
    }
    
    /**
     * The member that stores the base path of the repository
     */
    private final Path basePath;
	
}
