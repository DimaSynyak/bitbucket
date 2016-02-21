package ua.lardy.project.project.beans.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by root on 8/13/15.
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
