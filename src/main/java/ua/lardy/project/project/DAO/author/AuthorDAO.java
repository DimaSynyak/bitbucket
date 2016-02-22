package ua.lardy.project.project.DAO.author;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lardy.project.project.beans.author.Author;

import java.util.List;

/**
 * Класс, котроый описывает механизм управления данными в таблицах реляционного отображения.
 * Данный класс описывает управление реляционным отображением данных класса {@link Author}.
 * @author Sinyak D.V.
 * @version 1.0
 */
@Component(value = "authorDAO")
public class AuthorDAO implements IAuthorDAO {

    @Autowired
    private SessionFactory sessionFactory;


    public AuthorDAO() {
    }

    /**
     * Метод предназначен возвращать объекты, класса {@link Author}, из таблицы баз данных, которые удовлетворяют критерию поиска.
     * @param name строковая переменная, котроя принимает на вход имя автора. Критерий поиска.
     * @return Возвращает объект класса {@link Author}.
     */
    public Author getAuthorByName(String name) {
        Author author = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        author = (Author) session.createCriteria(Author.class).add(Restrictions.like("name", name)).uniqueResult();
        transaction.commit();
        return author;
    }

    /**
     * Метод предназначен возвращать списки всех объектов, класса {@link Author}, из таблицы баз данных.
     * @return Возвращает список объектов класса {@link Author}.
     */
    public List<Author> getAuthorList() {
        List<Author> authorList = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        authorList = session.createCriteria(Author.class).list();
        transaction.commit();
        return authorList;
    }

    /**
     * Метод предназначен возвращать объекты, класса {@link Author}, из таблицы баз данных, которые удовлетворяют критерию поиска.
     * @param login строковая переменная, которая принимает на вход логин автора. Критерий поиска.
     * @return Возвращает объект класса {@link Author}.
     */
    public Author getAuthorByLogin(String login) {
        Author author = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        author = (Author) session.createCriteria(Author.class).add(Restrictions.eq("login", login)).uniqueResult();
        transaction.commit();
        return author;
    }

    /**
     * Метод предназначен возвращать списки объектов, класса {@link Author}, из таблицы баз данных, которые удовлетворяют критерию поиска.
     * @param name строковый параметр, который принимает на вход имя или часть имени автора. Критерий поиска.
     * @return Возвращает список объектов класса {@link Author}.
     */
    public List<Author> getAuthorsByName(String name) {
        List<Author> authorList = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        authorList = (List<Author>) session.createCriteria(Author.class)
                .add(Restrictions.like("name", name + "%"))
                .list();
        transaction.commit();
        return authorList;
    }
}
