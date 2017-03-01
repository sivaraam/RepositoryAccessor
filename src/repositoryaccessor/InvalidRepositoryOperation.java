package repositoryaccessor;

public class InvalidRepositoryOperation extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	InvalidRepositoryOperation() {
		reason = "Unknown reason";
	}
	
	InvalidRepositoryOperation(String reason) {
		this.reason = reason;
	}
	
	public String what() {
		return reason;
	}
	
	String reason;
}
