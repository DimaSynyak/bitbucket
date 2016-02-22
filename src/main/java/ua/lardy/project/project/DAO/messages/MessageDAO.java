package ua.lardy.project.project.DAO.messages;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lardy.project.project.DAO.author.AuthorDAO;
import ua.lardy.project.project.DAO.category.CategoryDAO;
import ua.lardy.project.project.beans.author.Author;
import ua.lardy.project.project.beans.messages.Message;

import java.util.ArrayList;
import java.util.List;


/**
 * Класс, котроый описывает механизм управления данными в таблицах реляционного отображения.
 * Данный класс описывает управление реляционным отображением данных класса {@link Message}.
 * @author Sinyak D.V.
 * @version 1.0
 */
@Component(value = "messageDAO")
public class MessageDAO implements IMessageDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Метод предназначен возвращать списки объектов, класса {@link Message}, из таблицы баз данных.
     * @param category_id целочисленная переменная, котроя принимает на вход порядковый номер рубрики. Критерий поиска.
     * @return Возвращает список объектов класса {@link Message}.
     */
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

    /**
     * Метод предназначен возвращать списки всех объектов, класса {@link Message}, из таблицы баз данных.
     * @return Возвращает список объектов класса {@link Message}.
     */
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

    /**
     * Метод предназначен возвращать списки объектов, класса {@link Message}, из таблицы баз данных, которые удовлетворяют критериям поиска.
     * @param id_author целочисленная переменная, котроя принимает на вход порядковый номер автора. Критерий поиска.
     * @param id_category целочисленная переменная, которая принимает на вход порядковый номер рубрики. Критерий поиска.
     * @return Возвращает список объектов класса {@link Message}.
     */
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

    /**
     * Метод предназначен возвращать списки объектов, класса {@link Message}, из таблицы баз данных, которые удовлетворяют критериям поиска.
     * @param list ссылочная переменная, которая принимает на вход список объектов, класса {@link Author}. Критерий поиска.
     * @return Возвращает список объектов класса {@link Message}.
     */
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

    /**
     * Метод предназначен возвращать списки объектов, класса {@link Message}, из таблицы баз данных, которые удовлетворяют критериям поиска.
     * @param list ссылочная переменная, котроя принимает на вход список объектов, класса {@link Author}. Критерий поиска.
     * @param id_category целочисленная переменная, которая принимает на вход порядковый номер рубрики. Критерий поиска.
     * @return Возвращает список объектов класса {@link Message}.
     */
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

    /**
     * Метод предназначен возвращать списки объектов, класса {@link Message}, из таблицы баз данных, которые удовлетворяют критерию поиска.
     * @param message_id целочисленная переменная, котроя принимает на вход порядковый номер сообщения. Критерий поиска.
     * @return Возвращает список объектов класса {@link Message}.
     */
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

    /**
     * Метод предназначен возвращать объекты, класса {@link Message}, из таблицы баз данных, которые удовлетворяют критерию поиска.
     * @param title строковая переменная, котроя принимает на вход название сообщения. Критерий поиска.
     * @return Возвращает список объектов класса {@link Message}.
     */
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

    /**
     * Метод предназначен сохранять сообщения в таблице баз данных.
     * @param message ссылочная переменная переменная, котроя принимает на вход объект сообщения.
     */
    public void createMessage(Message message) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        session.save(message);
        transaction.commit();
    }

    /**
     * Метод предназначен удалять сообщения из таблицы баз данных.
     * @param id_message целочисленная переменная, котроя принимает на вход порядковый номер сообщения.
     */
    public void deleteMessage(int id_message) {
        Message message = getMessageById(id_message);
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        session.delete(message);
        transaction.commit();
    }

    /**
     * Метод предназначен обновлять сообщения в таблице баз данных.
     * @param message ссылочная переменная, котроя принимает на вход объект сообщения.
     */
    public void updateMessage(Message message) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        session.update(message);
        transaction.commit();
    }
}
