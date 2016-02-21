package ua.lardy.project.project.DAO.category;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lardy.project.project.beans.category.Category;

import java.util.List;

/**
 * Created by root on 8/13/15.
 */
@Component(value = "categoryDAO")
public class CategoryDAO implements ICategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Category> getCategories() {
        List<Category> categories = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        categories = (List<Category>) session.createCriteria(Category.class)
                .list();
        transaction.commit();
        return categories;
    }

    public Category getCategory() {
        Category category = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        category = (Category) session.createCriteria(Category.class)
                .add(Restrictions.eq("id", 1))
                .uniqueResult();
        transaction.commit();
        return category;
    }

    public Category getCategory(String name) {
        Category category = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        category = (Category) session.createCriteria(Category.class)
                .add(Restrictions.like("category", name))
                .uniqueResult();
        transaction.commit();
        return category;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
