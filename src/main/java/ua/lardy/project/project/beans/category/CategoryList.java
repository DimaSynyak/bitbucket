package ua.lardy.project.project.beans.category;

import org.springframework.beans.factory.annotation.Autowired;
import ua.lardy.project.project.DAO.category.CategoryDAO;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;
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

    public CategoryList(){}

    public List<Category> getCategories(){
        categories = categoryDAO.getCategories();
        return categories;
    }

    public Category getCategoryByName(String name){
        category = categoryDAO.getCategory(name);
        return category;
    }

    public Category getCategoryByFirst(){
        return categoryDAO.getCategory();
    }
}
