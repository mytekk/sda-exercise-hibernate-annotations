package pl.sda.exercise.hibernate;

import java.util.stream.Collectors;

import pl.sda.exercise.hibernate.service.AuthorService;

/**
 * Exercise 09: books for author
 */
public class Hibernate09 {

	public static void main(String[] args) {
		AuthorService authorService = new AuthorService();
		System.out.println("Authors:");
//		authorService.getAuthors().forEach(author -> {
//			System.out.println(author + "; " + author.getBooks()
//					.stream().map(b -> b.toString())
//					.collect(Collectors.joining("; ")));
//		});
	}

}
