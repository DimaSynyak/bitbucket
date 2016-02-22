package ua.lardy.project;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.lardy.project.project.DAO.author.AuthorDAO;
import ua.lardy.project.project.beans.author.Author;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by dmitriy on 18.02.16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/dispatcher.xml"})
public class TestAuthorDAO {

    @Autowired
    private AuthorDAO authorDAO;

    public TestAuthorDAO() {
    }

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetAuthorByName(){
        Author author = authorDAO.getAuthorByName("Dmitriy");
        assertTrue(author != null);
    }

    @Test
    public void testGetAuthorByLogin(){
        Author author = authorDAO.getAuthorByLogin("dm");
        assertTrue(author != null);
    }

    @Test
    public void testGetAuthorList(){
        List<Author> authorList = authorDAO.getAuthorList();
        assertTrue(authorList != null);
    }

    @Test
    public void testGetAuthorsByName() {
        List<Author> authorList = authorDAO.getAuthorsByName("Dmitriy");
        assertTrue(authorList != null);
    }
}
