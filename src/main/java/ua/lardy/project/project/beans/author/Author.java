package ua.lardy.project.project.beans.author;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * Класс служит шаблоном для отображения таблиц реляционных баз данных.
 * @author Sinyak D.V.
 * @version 1.0
 */

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", insertable = true, updatable = true)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "login")
    private String login;
    
    @Column(name = "password")
    private String password;

    public Author() {

    }

    /**
     * Метод предназначен возвращать значения приватного поля name
     * @return Возвращает имя автора
     */
    public String getName() {
        return name;
    }

    /**
     * Метод предназначен для записи приватного поля name
     * @param name строковая переменная, прнимает на вход имя автора.
     */
    public void setName(String name) {
        this.name = name;
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
     * Метод предназначен возвращать значения приватного поля password
     * @return Возвращает строковое значение пароля пользователя
     */
    public String getPassword() {
        return password;
    }

    /**
     * Метод предназначен возвращать значения приватного поля login
     * @return Возвращает строковое значения login пользователя
     */
    public String getLogin() {
        return login;
    }

    /**
     * Метод предназначен для записи приватного поля login
     * @param login строковая переменная, которая принимает на вход login пользователя.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Метод предназначен для записи приватного поля password
     * @param password строковая переменная, которая принимает на вход пароль пользователя.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
