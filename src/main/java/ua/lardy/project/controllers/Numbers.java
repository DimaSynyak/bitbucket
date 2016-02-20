package ua.lardy.project.controllers;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 * Created by dmitriy on 19.02.16.
 */
@Named
@SessionScoped
public class Numbers {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int add(){
        return ++i;
    }

    public void clear(){
        i = 0;
    }
}
