package ua.lardy.project.project.beans.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ua.lardy.project.project.DAO.messages.MessageDAO;
import ua.lardy.project.project.beans.author.Author;
import ua.lardy.project.project.beans.author.AuthorList;
import ua.lardy.project.project.beans.category.Category;
import ua.lardy.project.project.beans.category.CategoryList;
import ua.lardy.project.project.beans.CreateController;
import ua.lardy.project.project.beans.filter.Filter;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.util.*;

/**
 * Класс контроллер. Связывает отображение и модель объектов.
 * Принимает, обрабатывает и отправляет информацию на отображение.
 * @author Sinyak D.V.
 * @version 1.0
 */
@Named
@SessionScoped
public class MessageList {

    @Autowired
    private MessageDAO messageDAO;

    @Autowired
    private Filter filter;

    @Autowired
    private AuthorList authorList;

    @Autowired
    private CategoryList categoryList;

    @Autowired
    private CreateController createController;

    public MessageList() {
    }

    /**
     * Метод предназначен для формирования и возврата списка всех сообщений
     * @return Возвращает список сообщений типа {@link Message}
     */
    public List<Message> getMessages(){
        List<Message> messages = null;
        if (filter.isState()){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String name = auth.getName();
            Author author = authorList.getAuthorByName(name);
            Category category = categoryList.getCategoryByName(filter.getCategory());

            return messageDAO.getMessagesByAuthorAndCategory(author.getId(), category.getId());
        }

        if (filter.getSearch() != null && !filter.getSearch().isEmpty()){
            List<Author> authors = authorList.getAuthorsByName(filter.getSearch());
            Category category = categoryList.getCategoryByName(filter.getCategory());
            return messageDAO.getMessagesByAuthorsAndCategory(authors, category.getId());
        }

        Category category = categoryList.getCategoryByName(filter.getCategory());
        messages = messageDAO.getMessagesByCategoryId(category.getId());

        return messages;
    }

    /**
     * Метод предназначен для формирования и возврата списка сообщений отсортированных по автору.
     * @return Возвращает список сообщений типа {@link Message}
     */
    public List<Message> getAllMessagesByAuthor(){
        List<Message> messages = null;

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Author author = authorList.getAuthorByName(name);

        List<Author> authorList = new ArrayList<Author>();
        authorList.add(author);

        return messageDAO.getMessagesByAuthors(authorList);
    }

    /**
     * Метод предназначен для сохранения сообщения в базе данных.
     */
    public void createMessage(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Author author = authorList.getAuthorByName(name);
        Category category = categoryList.getCategoryByName(createController.getCategory());
        Date date = new Date();

        Message message = new Message();
        message.setContent(createController.getMessage());
        message.setId_author(author.getId());
        message.setId_category(category.getId());
        message.setDate(date.getTime());
        message.setTitle(createController.getTitle());

        messageDAO.createMessage(message);
        createController.setTitle("");
        createController.setMessage("");
        createController.setId_message(0);
    }

    /**
     * Метод предназначен для обновления данных объекта {@link Message}.
     * @param id_message порядковый номер сообщения в таблице баз данных.
     */
    public void edit(int id_message){
        Message message = messageDAO.getMessageById(id_message);
        createController.setTitle(message.getTitle());
        createController.setMessage(message.getContent());
        createController.setCategory(message.getCategory().getCategory());
        createController.setId_message(message.getId());
    }

    /**
     * Метод предназначен обновлять данные сообщения в таблице баз данных.
     * @param id_message порядковый номер сообщения в таблице баз данных.
     */
    public void update(int id_message){
        if (id_message == 0)
            return;
        Message message = messageDAO.getMessageById(id_message);
        message.setContent(createController.getMessage());
        message.setTitle(createController.getTitle());

        Date date = new Date();

        Category category = categoryList.getCategoryByName(createController.getCategory());

        message.setId_category(category.getId());
        message.setDate(date.getTime());

        messageDAO.updateMessage(message);

        createController.setTitle("");
        createController.setMessage("");
        createController.setId_message(0);
    }

    /**
     * Метод предназначен для удаления сообщений из таблицы баз данных.
     * @param id_message порядковый номер сообщение в таблице баз данных.
     */
    public void deleteMessage(int id_message){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Author author = authorList.getAuthorByName(name);
        Message message = messageDAO.getMessageById(id_message);

        if (message.getId_author() == author.getId()) {
            messageDAO.deleteMessage(id_message);
        }
    }

    /**
     * Метод предназначен возвращать объект фильтра (тип {@link Filter}).
     * @return Возвращает {@link Filter}.
     */
    public Filter getFilter() {
        return filter;
    }

    /**
     * Метод предназначен для записи объекта фильтра.
     * @param filter объект типа {@link Filter}.
     */
    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    /**
     * Метод предназначен возвращать объект {@link MessageDAO}.
     * @return Возвращает объект {@link MessageDAO}.
     */
    public MessageDAO getMessageDAO() {
        return messageDAO;
    }
}