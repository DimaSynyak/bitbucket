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
 * Created by root on 8/13/15.
 */
@Component(value = "authorDAO")
public class AuthorDAO implements IAuthorDAO {

    @Autowired
    private SessionFactory sessionFactory;


    public AuthorDAO() {
    }

    public void insertAuthor(Author author) {
//        session.save(author);
    }

    public Author getAuthorByName(String name) {
        Author author = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        author = (Author) session.createCriteria(Author.class).add(Restrictions.like("name", name)).uniqueResult();
        transaction.commit();
        return author;
    }

    public List<Author> getAuthorList() {
        List<Author> authorList = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        authorList = session.createCriteria(Author.class).list();
        transaction.commit();
        return authorList;
    }

    public Author getAuthorByLogin(String login) {
        Author author = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        author = (Author) session.createCriteria(Author.class).add(Restrictions.eq("login", login)).uniqueResult();
        transaction.commit();
        return author;
    }

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

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
