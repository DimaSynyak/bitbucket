package ua.lardy.project.beans.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lardy.project.DAO.category.CategoryDAO;
import ua.lardy.project.beans.category.Category;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 8/13/15.
 */
@Named
@SessionScoped
public class CategoryList {

    @Autowired
    private CategoryDAO categoryDAO;

    private List<Category> categories;
    private Category category;


    public List<Category> getCategories(){
        categories = categoryDAO.getCategories();
        return categories;
    }

    public Category getCategoryByName(String name){
        category = categoryDAO.getCategory(name);
        return category;
    }
}
