package main;
import Book.*;
import Loan.*;
import exception.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.*;
public class Library {
	private String name;
    private BookValidator bookValidator= new BookValidator();
    private LoanValidator loanValidator= new LoanValidator();
    private HashMap<String, Book> books=  new HashMap<>();
    private ArrayList<Loan> loans=  new ArrayList<>();

    public Library(String name) {
        this.name = name;
    }
    public void addBook(Book book) {
    	try {
    		bookValidator.validateISBN(book);
    		books.put(book.getiSBN(), book);
    		System.out.println("Book Added: "+ book.toString());
    	}
    	catch(InvalidBookException  e) {
    		System.out.println(e.getMessage());
    	}
    	
    	catch(NoSuchBookException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	}
    public void borrowBook(String borrower, String ISBN, LocalDate dueDate) {
    	try {
    		bookValidator.validateExistence(books, ISBN, name);
    		Book book = books.get(ISBN);
    		bookValidator.validateISBN(book);
    		loanValidator.validateDueDate(dueDate);
    		if(book.getisAvailable()) {
    			book.setAvailable(false);
    			Loan newLoan = new Loan( borrower,book, dueDate,false);
    			loans.add(newLoan);
    			System.out.println("Loan Created: "+ newLoan.toString());
    		}
    }
    		catch(InvalidBookException e){
    			System.out.println(e.getMessage());
    		}
    		catch( NoSuchBookException e) {
    			System.out.println(e.getMessage());
    		}
    		catch(InvalidLoanException e) {
    			System.out.println(e.getMessage());
    		}
    	
    }
    	
    public void returnBook(String ISBN) {
    	try {
    		bookValidator.validateExistence(books, ISBN, name);
    		Book book = books.get(ISBN);
    		bookValidator.validateISBN(book);
    		if(!book.getisAvailable()) {
    			book.setAvailable(true);
    			System.out.println("Book Returned: "+ book.toString());
    			for(Loan loan: this.loans) {
    				if(loan.getBook().getiSBN()==ISBN) {
    					loan.setReturned(true);
    					break;
    				}
    			}
    			
    		}
    	}
    	catch(InvalidBookException e){
    		System.out.println(e.getMessage());
    	}
    	catch(NoSuchBookException e) {
    		System.out.println(e.getMessage());
    	}
    }
    public String printAllLoans() {
    	String allLoans= "";
    	int loanNum= 0;
    	for(Loan loan: loans) {
    		loanNum +=1;
    		String loannumstr= Integer.toString(loanNum);
    		String loanInfo = loan.toString();
    		allLoans += "Loan "+loannumstr+" : "+loanInfo;
    	}
    	return allLoans;
    }
    public String printMatchingBooks(String titlePattern) {
    	String booksInfo= "";
    	for(String bookISBN: books.keySet()) {
    		Book book= books.get(bookISBN);
    		if(book.getTitle().contains(titlePattern)) {
    			booksInfo+= book.toString();
    		}
    	}
    	String matchinones= "Matching books with '"+titlePattern+"' :\n";
    	return matchinones+booksInfo;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BookValidator getBookValidator() {
		return bookValidator;
	}
	public void setBookValidator(BookValidator bookValidator) {
		this.bookValidator = bookValidator;
	}
	public LoanValidator getLoanValidator() {
		return loanValidator;
	}
	public void setLoanValidator(LoanValidator loanValidator) {
		this.loanValidator = loanValidator;
	}
	public HashMap<String, Book> getBooks() {
		return books;
	}
	public void setBooks(HashMap<String, Book> books) {
		this.books = books;
	}
	public ArrayList<Loan> getLoans() {
		return loans;
	}
	public void setLoans(ArrayList<Loan> loans) {
		this.loans = loans;
	}
	public void printLibraryCatalog() throws FileNotFoundException{
		try{
			FileOutputStream myfile = new FileOutputStream("libraryCatalog.txt");
            Formatter formatfile = new Formatter(myfile);
			for(String Isbn: this.books.keySet()) {
			Book book = books.get(Isbn);
			System.out.println(book.getisAvailable());
			if(book.getisAvailable()) {
				System.out.printf("Book Name: %s, ISBN: %s, Status: Available%n", book.getTitle(), book.getiSBN());
				formatfile.format("Book Name: %s, ISBN: %s, Status: Available%n", book.getTitle(), book.getiSBN());
			}
			else {
				for(Loan loan: this.loans) {
					if(loan.getBook().getiSBN()==book.getiSBN()) {
						System.out.printf("Book Name: %s, ISBN: %s, Status: On Loan - Borrower: %s, Due Date: %s%n", book.getTitle(), book.getiSBN(), loan.getBorrower(), loan.getDueDate());
				formatfile.format("Book Name: %s, ISBN: %s, Status: On Loan - Borrower: %s, Due Date: %s%n",
                        book.getTitle(), book.getiSBN(), loan.getBorrower(), loan.getDueDate());
				}}
			}	
		}
		formatfile.close();	
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
	}


}
    
	

