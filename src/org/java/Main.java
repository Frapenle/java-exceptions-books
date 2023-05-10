package org.java;

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
		int option = -1;
		boolean errCatch = false;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Quanti libri vuoi inserire?");
		numOfBooks = sc.nextInt();
		sc.nextLine();
		
		Book[] books = new Book[numOfBooks];
		while(counter < numOfBooks && !errCatch) {
			
			System.out.println("Titolo: ");
			String title = sc.nextLine();
			
			System.out.println("Author: ");
			String author = sc.nextLine();
			
			System.out.println("Numero di pagine: ");
			int pageNumbers = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Publisher: ");
			String publisher = sc.nextLine();		
			
			try {
				Book book = new Book(title, pageNumbers, author, publisher);
				books[counter++] = book;
			} catch (Exception e) {
				System.out.println("Errore... " + e.getMessage());
				errCatch = true;
			}
		}
		sc.close();
		
//		write to books.txt
		try (FileWriter myWriter = new FileWriter(FILEPATH)) {
		// creo un oggetto FileWriter
			for(int i = 0; i < books.length; i++) {
				// scrivo una stringa
				myWriter.write(books[i].toString()
						+ "\n --------------- \n");
			}
			// chiudo il FileWriter
			myWriter.close();
		} catch (Exception e) {
			System.out.println("Errore durante la scrittura nel file: "
								+ FILEPATH + " " + e.getMessage());
		}
	}
}
