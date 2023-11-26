package exception;

public class NoSuchBookException extends Exception{
	private String message;
	public NoSuchBookException(String message) {
		this.message = message;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		String first ="NoSuchBookException: Loan aborted because ";
		return first+this.message;
	}

	
	
}
