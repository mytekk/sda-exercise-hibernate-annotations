package pl.sda.exercise.hibernate;

import pl.sda.exercise.hibernate.model.Book;
import pl.sda.exercise.hibernate.service.BookService;

import java.util.List;

/**
 * Exercise 04: get books by name
 */
public class Hibernate04 {

	public static void main(String[] args) {
		BookService bookService = new BookService();
		String sampleTitle = "Charlie";

        List<Book> bookList = bookService.getBooksByTitle(sampleTitle);

        System.out.println("Books by title:" + bookList);
	}

}
