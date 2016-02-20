package ua.lardy.project.beans.messages;

import ua.lardy.project.beans.author.Author;
import ua.lardy.project.beans.category.Category;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by root on 8/13/15.
 */
@Entity
@Table(name = "message")
public class Message {
    @Id
    private int id;

    @Column(name = "date")
    private String date;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
