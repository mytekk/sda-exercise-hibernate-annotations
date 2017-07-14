package pl.sda.exercise.hibernate;

import pl.sda.exercise.hibernate.service.BookService;

/**
 * Exercise 01: get all books
 */
public class Hibernate01 {

	public static void main(String[] args) {
		BookService bookService = new BookService();
		System.out.println("Books:");
		bookService.getBooks().forEach(System.out::println);
	}

}
