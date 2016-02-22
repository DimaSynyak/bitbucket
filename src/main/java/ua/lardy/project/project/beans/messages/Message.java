package ua.lardy.project.project.beans.messages;

import ua.lardy.project.project.beans.author.Author;
import ua.lardy.project.project.beans.category.Category;

import javax.persistence.*;
import java.util.GregorianCalendar;

/**
 * Класс служит шаблоном для отображения таблиц реляционных баз данных.
 * Предназначен для хранения данных сообщений пользователей.
 * @author Sinyak D.V.
 * @version 1.0
 */
@Entity
@Table(name = "message")
public class Message {
    @Id
    private int id;

    @Column(name = "date")
    private long date;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;


    @Column(name = "id_category", insertable = true, updatable = true)
    private int id_category;

    @Column(name = "id_author", insertable = true, updatable = true)
    private int id_author;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category", referencedColumnName = "id", insertable = false, updatable = false)
    private Category category;

    @OneToOne(fetch =FetchType.EAGER)
    @JoinColumn(name = "id_author", referencedColumnName = "id", insertable = false, updatable = false)
    private Author author;


    public Message() {

    }

    /**
     * Метод предназначен для возврата значения приватного поля id
     * @return Возвращает порядковый номер сообщения.
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
     * Метод предназначен для возврата значения приватного поля id_author
     * @return - Возвращает порядковый номер объекта таблицы баз данных
     */
    public int getId_author() {
        return id_author;
    }

    /**
     * Метод предназначен для записи приватного поля id_author
     * @param id_author порядковый номер таблицы баз данных,тип int
     */
    public void setId_author(int id_author) {
        this.id_author = id_author;
    }

    /**
     * Метод предназначен для возврата рубрики из таблицы баз данных.
     * @return Возвращает объект типа {@link Category}
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Метод предназначен для записи объекта {@link Category}
     * @param category объект типа {@link Category}
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Метод предназначен возвращать объекты типа {@link Author}, содержащие информацию об авторе
     * @return Возвращает объект типа {@link Author}
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Метод предназначен для записи объекта {@link Author}
     * @param author объект типа {@link Author}
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * Метод предназначен для преобразования из целочисленного значение в строковое и возврата даты записи объекта в базу данных.
     * @return Возвращает строковое значение типа String
     */
    public String getDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(date);

        java.util.Date date2 = calendar.getTime();
        return date2.toString();
    }

    /**
     * Метод предназначен для записи даты в формате Unix time.
     * @param date принимает на вход дату в формате Unix time.
     */
    public void setDate(long date) {
        this.date = date;
    }

    /**
     * Метод предназначен возвращать значения приватного поля id_category.
     * @return Возвращает порядковый номер объекта таблицы баз данных.
     */
    public int getId_category() {
        return id_category;
    }

    /**
     * Метод предназначен для записи приватного поля id_category.
     * @param id_category принимает на вход порядковый номер таблицы баз данных,тип int.
     */
    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    /**
     * Метод предназначен возвращать строковое значение, название сообщения.
     * @return Возвращает название сообщения.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Метод предназначен для записи строкового значения названия сообщения.
     * @param title принимает на вход строковое значение, название сообщения.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Метод предназначен возвращать сообщения
     * @return Возвращает строковое значение, тело сообщения
     */
    public String getContent() {
        return content;
    }

    /**
     * Метод предназначен для записи сообщения
     * @param content принимает на вход строковое значение, сообщение
     */
    public void setContent(String content) {
        this.content = content;
    }

}
