package pl.sda.exercise.hibernate;

import pl.sda.exercise.hibernate.model.Book;
import pl.sda.exercise.hibernate.service.BookService;

/**
 * Exercise 07: delete book
 */
public class Hibernate07 {

	public static void main(String[] args) {
		BookService bookService = new BookService();
		for (Book book: bookService.getBooksByTitle("W pustyni i w puszczy")) {
			bookService.deleteBook(book);
		}
		System.out.println("Books:");
		bookService.getBooks().forEach(System.out::println);
	}

}
