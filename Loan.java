package Loan;

import java.time.LocalDate;
import Book.*;
public class Loan {
	String borrower;
	Book book;
	LocalDate dueDate;
	boolean isReturned;
	public Loan(String borrower, Book book, LocalDate dueDate,boolean isReturned) {
		this.borrower = borrower;
		this.book = book;
		this.dueDate = dueDate;
		this.isReturned= isReturned;
	}
	public String getBorrower() {
		return borrower;
	}
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public boolean isReturned() {
		return isReturned;
	}
	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String loanInfo = "Borrower: "+this.borrower+", Book: "+this.book.getTitle()+", Due date: "+this.dueDate.toString()+"\n";
		return loanInfo;
	}
	
}
