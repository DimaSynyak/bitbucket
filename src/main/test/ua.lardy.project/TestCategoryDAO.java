package ua.lardy.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.lardy.project.DAO.category.CategoryDAO;
import ua.lardy.project.beans.category.Category;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by dmitriy on 18.02.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:spring_test.xml"})
public class TestCategoryDAO {

    @Autowired
    private CategoryDAO categoryDAO;

    @Test
    public void testGetCategories(){
        List<Category> categories = categoryDAO.getCategories();
        assertTrue(categories != null);
    }

    @Test
    public void testGetCategory(){
        Category category = categoryDAO.getCategory();
        assertTrue(category != null);
    }

    @Test
    public void testGetCategoryByName(){
        Category category = categoryDAO.getCategory("SELL");
        assertTrue(category != null);
    }
}
