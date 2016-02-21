package ua.lardy.project.project.DAO.messages;


import ua.lardy.project.project.beans.author.Author;
import ua.lardy.project.project.beans.messages.Message;

import java.util.List;

/**
 * Created by root on 8/13/15.
 */
public interface IMessageDAO {

    List<Message> getMessagesByCategoryId(int category_id);
    List<Message> getMessages();
    List<Message> getMessagesByAuthorAndCategory(int id_author, int id_category);
    List<Message> getMessagesByAuthors(List<Author> list);
    List<Message> getMessagesByAuthorsAndCategory(List<Author> list, int id_category);
    Message getMessageById(int message_id);
    Message getMessageByTitle(String title);
    void createMessage(Message message);
    void deleteMessage(int id_message);
    void updateMessage(Message message);


}
