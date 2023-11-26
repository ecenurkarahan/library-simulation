package exception;

public class InvalidLoanException extends Exception {
	private String message;
	public InvalidLoanException (String message) {
		this.message= message;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		String first ="InvalidLoanException: Loan is invalid because " ;
		String message = this.message;
		return first+message;
	}
	
}
