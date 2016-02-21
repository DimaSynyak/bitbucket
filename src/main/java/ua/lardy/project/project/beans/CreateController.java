package ua.lardy.project.project.beans;


import org.springframework.beans.factory.annotation.Autowired;
import ua.lardy.project.project.beans.category.CategoryList;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;


/**
 * Created by dmitriy on 19.02.16.
 */
@Named
@SessionScoped
public class CreateController {

    @Autowired
    private CategoryList categoryList;

    private String category;
    private String title;
    private String message;
    private int id_message;

    public CreateController() {

    }

    @PostConstruct
    public void init(){
        this.category = "SELL";//categoryList.getCategoryByFirst().getCategory();
        title = "";
        message = "";
        id_message = 0;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }
}
