package ua.lardy.project.DAO.messages;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lardy.project.DAO.AOP.annotation.Receiver;
import ua.lardy.project.DAO.author.AuthorDAO;
import ua.lardy.project.DAO.category.CategoryDAO;
import ua.lardy.project.beans.author.Author;
import ua.lardy.project.beans.messages.Message;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by root on 8/13/15.
 */
@Component(value = "messageDAO")
public class MessageDAO implements IMessageDAO {


    private String filter;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private AuthorDAO authorDAO;

    @Autowired
    private CategoryDAO categoryDAO;


    public List<Message> getMessagesByCategoryId(int category_id) {
        List<Message> messages = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        messages = (List<Message>) session.createCriteria(Message.class)
                .add(Restrictions.eq("id_category", category_id))
                .list();
        transaction.commit();

        return messages;
    }


    public List<Message> getMessages() {
        List<Message> messages = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        messages = (List<Message>) session.createCriteria(Message.class)
                .list();
        transaction.commit();

        return messages;
    }

    public List<Message> getMessagesByAuthorAndCategory(int id_author, int id_category) {
        List<Message> messages = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();

        Criteria cr = session.createCriteria(Message.class);
        Criterion authorAndCategory = Restrictions.and(Restrictions.eq("id_author", id_author), Restrictions.eq("id_category", id_category));
        cr.add(authorAndCategory);
        messages = (List<Message>) cr.list();
        transaction.commit();
        return messages;
    }

    public List<Message> getMessagesByAuthors(List<Author> list) {
        List<Message> messages = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();

        Criteria cr = session.createCriteria(Message.class);
        for (Author author : list) {
            cr.add(Restrictions.eq("id_author", author.getId()));
        }

        messages = (List<Message>) cr.list();
        transaction.commit();
        return messages;
    }

    public List<Message> getMessagesByAuthorsAndCategory(List<Author> list, int id_category) {
        List<Message> messages = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();

        Criteria cr = session.createCriteria(Message.class);

        if (list.size() == 0){
            return new ArrayList<Message>();
        }

        for (Author author : list) {
            Criterion criterion = Restrictions.and(Restrictions.eq("id_author", author.getId()), Restrictions.eq("id_category", id_category));
            cr.add(criterion);
        }




        messages = (List<Message>) cr.list();
        transaction.commit();
        return messages;
    }

    public Message getMessageById(int message_id) {
        Message message = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        message = (Message) session.createCriteria(Message.class)
                .add(Restrictions.eq("id", message_id))
                .uniqueResult();
        transaction.commit();

        return message;
    }

    public Message getMessageByTitle(String title) {
        Message message = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();

        message = (Message) session.createCriteria(Message.class)
                .add(Restrictions.eq("title", title))
                .uniqueResult();
        transaction.commit();

        return message;
    }

    public void createMessage(Message message) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        session.save(message);
        transaction.commit();
    }

    public void deleteMessage(int id_message) {
        Message message = getMessageById(id_message);
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        session.delete(message);
        transaction.commit();
    }

    public void updateMessage(Message message) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        session.update(message);
        transaction.commit();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public AuthorDAO getAuthorDAO() {
        return authorDAO;
    }

    public void setAuthorDAO(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    public CategoryDAO getCategoryDAO() {
        return categoryDAO;
    }

    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }
}
