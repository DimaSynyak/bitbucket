package ua.lardy.project.project.beans.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Класс служит шаблоном для отображения таблиц реляционных баз данных.
 * @author Sinyak D.V.
 * @version 1.0
 */
@Entity
@Table(name = "category")
public class Category {
    @Id
    private int id;

    @Column(name = "category")
    private String category;

    public Category() {

    }

    /**
     * Метод предназначен возвращать значения приватного поля id
     * @return Возвращает порядковый номер объекта таблицы баз данных
     */
    public int getId() {
        return id;
    }

    /**
     * Метод предназначен для записи приватного поля id
     * @param id порядковый номер таблицы баз данных,тип int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Метод предназначен возвращать значения приватного поля category
     * @return Возвращает строковое значение рубрики
     */
    public String getCategory() {
        return category;
    }

    /**
     * Метод предназначен для записи приватного поля login
     * @param category строковая переменная category, тип String
     */
    public void setCategory(String category) {
        this.category = category;
    }
}
