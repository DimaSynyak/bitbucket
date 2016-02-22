package ua.lardy.project.project.beans;


import org.springframework.beans.factory.annotation.Autowired;
import ua.lardy.project.project.beans.category.CategoryList;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;


/**
 * Класс контроллер. Связывает отображение и модель объектов.
 * Предназначен для хранения данных вновь создаваемых объектов сообщений.
 * @author Sinyak D.V.
 * @version 1.0
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

    /**
     * Метод предназначен для инициализации полей объекта.
     */
    @PostConstruct
    public void init(){
        this.category = "SELL";//categoryList.getCategoryByFirst().getCategory();
        title = "";
        message = "";
        id_message = 0;
    }

    /**
     * Метод предназначен возвращать строковое значение рубрики.
     * @return Возвращает строковое значение рубрики.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Метод предназначен для записи рубрики.
     * @param category строковое значение, которое принимает на вход название рубрики.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Метод предназначен возвращать название сообщения.
     * @return Возвращает строковое значение названия сообщения.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Метод предназначен для записи названия сообщения.
     * @param title строковое значение, которое принимает на вход название сообщения.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Метод предназначен возвращать сообщение
     * @return Возвращает строковое значение сообщения
     */
    public String getMessage() {
        return message;
    }

    /**
     * Метод предназначен для записи сообщения.
     * @param message строковое значение, которое принимает на вход сообщение.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Метод предназначен возвращать порядковый номер сообщения.
     * @return Возвращает порядковый номер сообщения  в таблице баз данных.
     */
    public int getId_message() {
        return id_message;
    }

    /**
     * Метод предназначен для записи порядкового номера сообщения.
     * @param id_message порядковый номер сообщения в таблице баз данных.
     */
    public void setId_message(int id_message) {
        this.id_message = id_message;
    }
}
