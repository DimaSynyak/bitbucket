package ua.lardy.project.project.beans.category;

import org.springframework.beans.factory.annotation.Autowired;
import ua.lardy.project.project.DAO.category.CategoryDAO;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.util.List;

/**
 * Класс контроллер. Связывает отображение и модель объектов.
 * @author Sinyak D.V
 * @version 1.0
 */
@Named
@SessionScoped
public class CategoryList {

    @Autowired
    private CategoryDAO categoryDAO;

    private List<Category> categories;
    private Category category;

    public CategoryList(){}

    /**
     * Метод предназначен для возврата списка рубрик из таблицы баз данных.
     * @return Возвращает все рубрики из таблиц баз данных
     */
    public List<Category> getCategories(){
        categories = categoryDAO.getCategories();
        return categories;
    }

    /**
     * Метод предназначен для возврата рубрики из таблицы базданных.
     * @param name строковое значение, которое принимает на вход название рубрики. Критерий поиска.
     * @return Возвращает объект типа {@link Category}
     */
    public Category getCategoryByName(String name){
        category = categoryDAO.getCategory(name);
        return category;
    }

    public Category getCategoryFirst(){
        return categoryDAO.getCategory();
    }
}
