package org.java;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import org.java.book.Book;

public class Main {
	private static final String FILEPATH = "/Users/frakb24/Desktop/Java/Lezione 5 - 23-05-10/books.txt";
	public static void main(String[] args) {
		printBooksToFile();
		
	}
	private static void printBooksToFile() {
		int numOfBooks;
		int counter = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Quanti libri vuoi inserire?");
		numOfBooks = sc.nextInt();
		sc.nextLine();
		
		Book[] books = new Book[numOfBooks];
		
		while(counter < numOfBooks) {
			
			try {
			System.out.println("Titolo: ");
			String title = sc.nextLine();
			
			System.out.println("Author: ");
			String author = sc.nextLine();
			
			System.out.println("Numero di pagine: ");
			int pageNumbers = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Publisher: ");
			String publisher = sc.nextLine();		
			
				Book book = new Book(title, pageNumbers, author, publisher);
				books[counter++] = book;
			} catch (Exception e) {
				counter--;
				System.out.println("Errore... " + e.getMessage());
			}
		}
		sc.close();
		
//		write to books.txt
		try (FileWriter myWriter = new FileWriter(FILEPATH)) {
			for(Book book : books) {
				myWriter.write(book.toString()
						+ "\n --------------- \n");
			}
		} catch (Exception e) {
			System.out.println("Errore durante la scrittura nel file: "
								+ FILEPATH + " " + e.getMessage());
		}
		
		try {
			File mioFile = new File(FILEPATH);
			// creo un oggetto Scanner passandogli il File
			Scanner reader = new Scanner(mioFile);
			// leggo riga per riga
			while (reader.hasNextLine()) {
				String data = reader.nextLine();
				System.out.print(data);
			}
			// chiudo lo Scanner
			reader.close();
			} catch (Exception e) {
				System.err.println("Errore durante la lettura: " + e.getMessage());
			}
	}
}
