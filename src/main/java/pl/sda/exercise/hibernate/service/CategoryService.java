package pl.sda.exercise.hibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.sda.exercise.hibernate.model.Category;

import java.util.List;

public class CategoryService {

    private SessionFactory sessionFactory;

    public CategoryService() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public List<Category> getCategoriesWithBooks() {

        Session session = sessionFactory.openSession();

        Query<Category> query = session.createNamedQuery("getAllCategories", Category.class);
        List<Category> categories = query.list();

        session.close();

        return categories;
    }
}
