package ua.lardy.project.project.DAO.category;


import ua.lardy.project.project.beans.category.Category;

import java.util.List;

/**
 * Created by root on 8/13/15.
 */
public interface ICategoryDAO {
    List<Category> getCategories();
    Category getCategory();
    Category getCategory(String name);
}
