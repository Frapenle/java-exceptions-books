package org.java.book;

public class Book {
	private String title;
	private int pageNumbers;
	private String author;
	private String publisher;
	
	
	public Book(String title, int pageNumbers, String author, String publisher) throws Exception {
		setTitle(title);
		setPageNumbers(pageNumbers);
		setAuthor(author);
		setPublisher(publisher);
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) throws Exception {
		if(title.trim().length() <= 0) {
			throw new Exception("Il titolo non puo essere vuoto.");
		}
		this.title = title;
	}


	public int getPageNumbers() {
		return pageNumbers;
	}
	public void setPageNumbers(int pageNumbers) throws Exception {
		if(pageNumbers <= 0) {
			throw new Exception("Il libro deve avere almeno una pagina.");
		}
		this.pageNumbers = pageNumbers;
	}


	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) throws Exception{
		if(title.trim().length() <= 0) {
			throw new Exception("L'autore non puo essere vuoto.");			
		}
		this.author = author;
	}


	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return "Titolo: " + getTitle()
				+ "\n Autore: " + getAuthor()
				+ "\n Editore: " + getPublisher()
				+ "\n Pagine: " + getPageNumbers()
				+ "\n ----------------- ";
	}
	
}
