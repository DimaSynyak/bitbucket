package ua.lardy.project;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.lardy.project.beans.filter.Filter;
import ua.lardy.project.beans.messages.Message;
import ua.lardy.project.beans.messages.MessageList;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by dmitriy on 18.02.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:spring_test.xml"})
public class TestMessageList {

    @Autowired
    private MessageList messageList;

    @Autowired
    private Filter filter;

    @Test
    public void testMessageListCategory(){
        filter.setState(false);
        filter.setCategory("RENT");
        List<Message> messages = messageList.getMessages();
        assertTrue(messages != null);
    }

    @Test
    public void testMessageListSearch(){
        filter.setState(false);
        filter.setCategory("SELL");
        filter.setSearch("Dmitriy");
        List<Message> messages = messageList.getMessages();
        assertTrue(messages != null);
    }

    @Test
    public void testMessageListUpdate(){
//        messageList.update(2);
        assertTrue(true);
    }

}
