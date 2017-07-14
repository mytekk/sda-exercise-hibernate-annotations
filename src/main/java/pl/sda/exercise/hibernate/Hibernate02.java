package pl.sda.exercise.hibernate;

import pl.sda.exercise.hibernate.service.BookService;

/**
 * Exercise 02: count all books
 */
public class Hibernate02 {

	public static void main(String[] args) {
		BookService bookService = new BookService();
		System.out.println("Books count:" + bookService.countBooks());
	}

}
