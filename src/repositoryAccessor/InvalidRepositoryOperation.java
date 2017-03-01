package repositoryAccessor;

/**
 * Class thrown by <code> RepositoryAccessor </code> in cases of an exception.
 *
 * @author Kaartic Sivaraam
 */
public class InvalidRepositoryOperation extends Exception{
	
	private static final long serialVersionUID = 1L;

	public InvalidRepositoryOperation() {
		reason = "Unknown reason";
	}
	
	public InvalidRepositoryOperation(String reason) {
		this.reason = reason;
	}
	
        @Override
	public String getMessage() {
            return reason+((super.getMessage() != null) ? super.getMessage() : "");
	}
	
	private String reason;
}
