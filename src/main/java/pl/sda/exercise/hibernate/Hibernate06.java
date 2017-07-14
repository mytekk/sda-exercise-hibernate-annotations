package pl.sda.exercise.hibernate;

import pl.sda.exercise.hibernate.model.Book;
import pl.sda.exercise.hibernate.service.BookService;

/**
 * Exercise 06: update book
 */
public class Hibernate06 {

	public static void main(String[] args) {
		BookService bookService = new BookService();
		for (Book book: bookService.getBooksByTitle("W póstyni i w pószczy")) {
			book.setTitle("W pustyni i w puszczy");
			bookService.updateBook(book);
		}
		System.out.println("Books:");
		bookService.getBooks().forEach(System.out::println);
	}

}
