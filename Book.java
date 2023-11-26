package Book;

public class Book {
	private String iSBN;
	private String title ;
	private String author;
	private boolean isAvailable;
	public Book(String iSBN, String title, String author, boolean isAvailable) {
		
		this.iSBN = iSBN;
		this.title = title;
		this.author = author;
		this.isAvailable = isAvailable;
	}
	public String getiSBN() {
		return iSBN;
	}
	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean getisAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String bookInfo= this.title+" , ISBN: "+this.iSBN+", Author: "+this.author+"\n";
		return bookInfo;
	}
	
}
