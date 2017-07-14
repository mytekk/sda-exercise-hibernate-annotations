package pl.sda.exercise.hibernate;

import pl.sda.exercise.hibernate.service.BookService;

/**
 * Exercise 04: get books by name
 */
public class Hibernate04 {

	public static void main(String[] args) {
		BookService bookService = new BookService();
		int id = 1;
		System.out.println("Book by id:" + bookService.getBookById(id));
	}

}
