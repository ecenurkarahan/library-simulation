package exception;

public class InvalidBookException extends Exception {
	

	private String message;
	public InvalidBookException(String message) {
		this.message= message;		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		String whyInvalid = this.message;
		String invalidbook= "InvalidBookException: Book is invalid because ";
		return invalidbook+whyInvalid;
	}
	
}
