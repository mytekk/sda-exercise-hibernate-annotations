package pl.sda.exercise.hibernate;

import pl.sda.exercise.hibernate.model.Category;
import pl.sda.exercise.hibernate.service.BookService;
import pl.sda.exercise.hibernate.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Exercise 10: books for categories
 */
public class Hibernate11 {

	public static void main(String[] args) {

		CategoryService categoryService = new CategoryService();
		System.out.println("Categories with books:");

		List<Category> categoriesWithBooks = categoryService.getCategoriesWithBooks();

		categoriesWithBooks.forEach(category -> {
			System.out.println((category + "; Books in this category:  " + category.getSetOfBooks().stream()
					.map(book -> book.toString())
					.collect(Collectors.joining("; "))
			));
		});

	}

}
