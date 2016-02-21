package ua.lardy.project.project.beans.filter;

import org.springframework.beans.factory.annotation.Autowired;
import ua.lardy.project.project.beans.category.CategoryList;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 * Created by dmitriy on 18.02.16.
 */
@Named
@SessionScoped
public class Filter {

    private boolean state;
    private String category;
    private String search;

    @Autowired
    private CategoryList categoryList;

    public Filter() {

    }

    @PostConstruct
    public void init(){
        this.state = false;
        category = "SELL";
        search = "";
    }

    public String doFilter(){
        return "view.xhtml";
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
