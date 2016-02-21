package ua.lardy.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.lardy.project.project.DAO.messages.MessageDAO;
import ua.lardy.project.project.beans.author.Author;
import ua.lardy.project.project.beans.messages.Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by dmitriy on 18.02.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/dispatcher.xml"})
public class TestMessagesDAO {

    @Autowired
    private MessageDAO messageDAO;

    @Test
    public void testGetMessagesByCategoryId(){
        List<Message> messages = messageDAO.getMessagesByCategoryId(1);
        assertTrue(messages != null);
    }

    @Test
    public void testGetMessages(){
        List<Message> messages = messageDAO.getMessages();
        assertTrue(messages != null);
    }

    @Test
    public void testGetMessagesByAuthorAndCategory(){
        List<Message> messages = messageDAO.getMessagesByAuthorAndCategory(1, 1);
        assertTrue(messages != null);
    }

    @Test
    public void testGetMessageById(){
        Message message = messageDAO.getMessageById(1);
        assertTrue(message != null);
    }

    @Test
    public void testGetMessagesByAuthors(){
        Author author = new Author();
        author.setId(1);
        author.setName("Dmitriy");
        author.setPassword("111");
        author.setLogin("dm");

        List<Author> list = new ArrayList<Author>();
        list.add(author);

        List<Message> messages = messageDAO.getMessagesByAuthors(list);
        assertTrue(messages != null);
    }

    @Test
    public void testGetMessagesByAuthorsAndCategory(){
        Author author = new Author();
        author.setId(1);
        author.setName("Dmitriy");
        author.setPassword("111");
        author.setLogin("dm");

        Author author2 = new Author();
        author.setId(2);
        author.setName("Aleksandra");
        author.setPassword("222");
        author.setLogin("al");

        List<Author> list = new ArrayList<Author>();
        list.add(author);
        list.add(author2);



        List<Message> messages = messageDAO.getMessagesByAuthorsAndCategory(list, 1);
        assertTrue(messages != null);
    }

    @Test
    public void testGetMessagesByAuthorsAndCategory2(){
        List<Author> list = new ArrayList<Author>();
        list.clear();

        List<Message> messages = messageDAO.getMessagesByAuthorsAndCategory(list, 1);
        assertTrue(messages.size() == 0);
    }

    @Test
    public void testCreateMessage(){
        Message message = new Message();
        message.setTitle("!!!Title!!!");
        message.setContent("Content");
        message.setDate(new Date().getTime());
        message.setId_author(1);
        message.setId_category(1);

        messageDAO.createMessage(message);

        Message message2 = messageDAO.getMessageByTitle("!!!Title!!!");
        messageDAO.deleteMessage(message2.getId());
        assertTrue(message.getTitle().equals(message2.getTitle()));
    }

//    @Test
//    public void test(){
//        assertTrue(true);
//    }

}
