package ua.lardy.project.controllers;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 * Created by dmitriy on 19.02.16.
 */
@Named
@SessionScoped
public class CreateController {
    private String category;
    private String title;
    private String message;
    private int id_message;

    public CreateController() {
        this.category = "SELL";
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
