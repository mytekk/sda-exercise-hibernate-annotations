package pl.sda.exercise.hibernate;

import pl.sda.exercise.hibernate.model.Book;
import pl.sda.exercise.hibernate.service.BookService;

/**
 * Exercise 05: create book
 */
public class Hibernate05 {

	public static void main(String[] args) {
		BookService bookService = new BookService();
		Book book = new Book();
		book.setTitle("W póstyni i w pószczy");
		bookService.createBook(book);
		System.out.println("Books:");
		bookService.getBooks().forEach(System.out::println);
	}

}
