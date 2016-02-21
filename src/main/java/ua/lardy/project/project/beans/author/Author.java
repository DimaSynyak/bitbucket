package ua.lardy.project.project.beans.author;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * @author Sinyak D.V.
 * Messages Board
 * @version 1.0
 */

@Entity
@Table(name = "author")
public class Author {

    /**
     * int значение, которое содержит порядковый номер, созданного на основе класса Author, объекта
     */
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", insertable = true, updatable = true)
    private int id;

    /**
     * String значение, которое содержит имя, созданного на основе класса Author, объекта
     */
    @Column(name = "name")
    private String name;

    /**
     * String значение, которое содержит логин, созданного на основе класса Author, объекта
     */
    @Column(name = "login")
    private String login;

    /**
     * String значение, которое содержит пароль, созданного на основе класса Author, объекта
     */
    @Column(name = "password")
    private String password;

    public Author() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
