package pl.sda.exercise.hibernate.service;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
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

		Session session = sessionFactory.openSession();
		Query<Long> query = session.createNamedQuery("countBooksQuery", Long.class);
		Long result = query.uniqueResult();
		session.close();

		return result;
	}

	public Book getBookById(int id) {

		Session session = sessionFactory.openSession();
		Query<Book> query = session.createNamedQuery("getBookById", Book.class);
		query.setParameter("id", id);
		Book book = query.uniqueResult();
		session.close();

		return book;
	}

	public List<Book> getBooksByTitle(String title) {

		Session session = sessionFactory.openSession();
		Query<Book> query = session.createNamedQuery("getBooksByTitle", Book.class);
		query.setParameter("title", '%' + title + '%');
		List<Book> list = query.list();

		return list;
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
