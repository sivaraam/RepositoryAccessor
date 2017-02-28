package repositoryAccessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author kaartic
 *
 */
public class RepositoryAccessor {

    RepositoryAccessor(String base) throws InvalidRepositoryOperation {
        basePath = Paths.get(base);
	if(Files.notExists(basePath)) {
		throw new InvalidRepositoryOperation ("The Base Path does not exist");
	}
    }
	
    Object[] readContentsFromFile(String relativePath) throws InvalidRepositoryOperation {
        Path filePath = Paths.get(basePath.toString(), relativePath);
	if(Files.notExists(filePath))
            throw new InvalidRepositoryOperation ("File does not exist");
	
        List<String> lines = new ArrayList<>();
	
        try(InputStream in = Files.newInputStream(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));) {
                String line;
                while((line = reader.readLine()) != null) {
                    lines.add(line);
                }        
        }  
        catch (IOException ex) {
            Logger.getLogger(RepositoryAccessor.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return lines.toArray();
    }
                
    private final Path basePath;
	
}
