package Loan;

import java.time.LocalDate;

import Book.Book;
import exception.*;

public class LoanValidator {
	public void validateDueDate(LocalDate dueDate) throws InvalidLoanException {
		LocalDate curDate =LocalDate.now();
		
		if(dueDate.isBefore(curDate)) {
			InvalidLoanException exception = new InvalidLoanException("the dueDate should be after the current date");
			
			throw exception;
			
		}
	}
	public void validateBookExistence(Book book) throws InvalidLoanException {
		if(!book.getisAvailable()) {
			InvalidLoanException exception = new InvalidLoanException("\"The book with ISBN "+book.getiSBN()+ "is not available for loan.");
			throw exception;
		}
	}
}
