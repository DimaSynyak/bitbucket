package ua.lardy.project.project.beans;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 * Created by dmitriy on 19.02.16.
 */
@Named
@SessionScoped
public class Numbers {
    private int i;

    public Numbers() {

    }

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
