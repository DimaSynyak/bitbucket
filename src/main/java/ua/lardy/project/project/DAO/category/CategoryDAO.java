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
 * Класс, котроый описывает механизм управления данными в таблицах реляционного отображения.
 * Данный класс описывает управление реляционным отображением данных класса {@link Category}.
 * @author Sinyak D.V.
 * @version 1.0
 */
@Component(value = "categoryDAO")
public class CategoryDAO implements ICategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Метод предназначен возвращать списки всех объектов, класса {@link Category}, из таблицы баз данных.
     * @return Возвращает список объектов класса {@link Category}.
     */
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

    /**
     * Метод предназначен возвращать объекты, класса {@link Category}, из таблицы баз данных, которые удовлетворяют критерию поиска.
     * @return Возвращает первый объект класса {@link Category}.
     */
    public Category getCategory() {
        Category category = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        category = (Category) session.createCriteria(Category.class)
                .add(Restrictions.eq("id", FIRST_OBJECT))
                .uniqueResult();
        transaction.commit();
        return category;
    }

    /**
     * Метод предназначен возвращать объекты, класса {@link Category}, из таблицы баз данных, которые удовлетворяют критерию поиска.
     * @param name строковая переменная, которая принимает на вход название рубрики. Критерий поиска.
     * @return Возвращает объект класса {@link Category}.
     */
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
}
