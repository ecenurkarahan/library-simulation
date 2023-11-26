package Book;

import java.util.*;

import exception.*;

public class BookValidator {
	public  void validateISBN(Book book) throws InvalidBookException, NoSuchBookException{
		String ISBN= book.getiSBN();
		if(ISBN.length()<13) {
			InvalidBookException exception =new InvalidBookException("the length of the ISBN should be 13");
			throw exception;
			
		}
		else if(!ISBN.matches("\\d{13}")) {
			InvalidBookException exception= new InvalidBookException("the ISBN should contain only numeric characters");
			throw exception;
		}
		
	}
	public void validateExistence(Map<String, Book> books, String ISBN, String libraryName) throws NoSuchBookException {
		
		 if(!books.containsKey(ISBN)) {
			 NoSuchBookException exception = new NoSuchBookException("the book with ISBN "+ISBN+" does not exist in the "+libraryName+" library");
			 
			 throw exception;
		}
	}
	
}
