package pl.sda.exercise.hibernate.service;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.sda.exercise.hibernate.model.Book;

public class BookService {

	private SessionFactory sessionFactory;

	public BookService() {
		this.sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public List<Book> getBooks() {

		Session session = sessionFactory.openSession();

		List<Book> queryResult = session.createNamedQuery("ourQueryForAllBooks", Book.class).list();

		session.close();

		return queryResult;
	}

	public long countBooks() {
		//TODO
		return 0;
	}

	public List<Book> getBookById(int id) {
		//TODO
		return null;
	}

	public List<Book> getBooksByTitle(String title) {
		//TODO
		return new LinkedList<>();
	}

	public void createBook(Book book) {
		//TODO
	}

	public void updateBook(Book book) {
		//TODO
	}

	public void deleteBook(Book book) {
		//TODO
	}

}
