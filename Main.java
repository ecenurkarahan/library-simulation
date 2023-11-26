package main;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

import Book.*;
import Loan.*;

// Import necessary classes
/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Ece Nur Karahan, 80029>
********************************************************************************/

public class Main {
    public static void main(String[] args) {
        // Create a library
    	Library myLibrary= new Library("MyLibrary");
        // ToDo: Add books to the library via reading from text file with Scanner
        // !! Do not forget to handle exceptions
    	ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String path = classLoader.getResource("Main/Input.txt").getPath();
    	try(Scanner input = new Scanner(new File(path))) {
            String[][] dataList= new String[5][5];
             // read record from file
             while (input.hasNext()) { // while there is more to read
             	for(int j =0; j<5;j++) {
             		for(int i =0; i<5;i++) {
             			String word = input.next();
             			dataList[j][i]= word;
             			
             }
             			
             }
             	
             	}
             
             
             for(int k =0; k<5;k++) {
             	String ISBN= dataList[k][0];
             	String title1 = dataList[k][1];
             	String title2 = dataList[k][2];
             	String title = title1+" "+title2;
             	String author1 = dataList[k][3];
             	String author2 = dataList[k][4];
             	String author = author1+" "+author2;
             	//System.out.println(ISBN+" "+title+" "+author+" ");
             	Book myBook= new Book(ISBN,title,author,true);
             	myLibrary.addBook(myBook);
             }
          } 
    	catch ( IOException| NoSuchElementException | 
                IllegalStateException e) {
                e.printStackTrace();
             }
    	
        // ToDo: Create loans via calling borrowBook method of library
        // !! Do not forget to handle exceptions
    	System.out.println("------------*LOANS*------------------");
    	LocalDate date1 = LocalDate.of(2023, 06, 05);
    	myLibrary.borrowBook("Fatma", "1234567890123", date1);
    	LocalDate date2 = LocalDate.of(2023,06,10);
    	myLibrary.borrowBook("Vahideh", "2345678901234", date2);
    	myLibrary.borrowBook("Ece", "123456789012X", date2);
    	myLibrary.borrowBook("Ece", "1111111111111", date2);
    	LocalDate date3 = LocalDate.of(2023,03,10);
    	myLibrary.borrowBook("Ece", "5678901234567", date3);


        // ToDo: Get returns via calling returnBook method of library
        // !! Do not forget to handle exceptions
    	System.out.println("------------*RETURNS*------------------");
    	//myLibrary.returnBook("1234567890123");
    	myLibrary.returnBook("2345678901234");
    	myLibrary.returnBook("1111111111111");

        System.out.println("All Loans: ");

        // ToDo: Print all loans 
        System.out.println(myLibrary.printAllLoans());
        // ToDo: Print all books that includes "Programming" in its name
        System.out.println(myLibrary.printMatchingBooks("Programming"));
        
        System.out.println("--------INLAB TASK1------------");
        myLibrary.borrowBook("Okan", "1234567890123", date1);
        myLibrary.returnBook("1234567890123");
        myLibrary.borrowBook("Ece", "1111111111111", date2);
        System.out.println(myLibrary.printAllLoans());
        System.out.println(myLibrary.printMatchingBooks("Programming"));
        System.out.println("Task2------------------------");
        
        try{
        	myLibrary.printLibraryCatalog();
        }
        catch(FileNotFoundException e){
			e.printStackTrace();
        }
        

    }
}

