package ua.lardy.project.project.beans;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 * Класс контроллер. Связывает отображение и модель объектов.
 * Предназначен для хранения данных цикла.
 * @author Sinyak D.V.
 * @version 1.0
 */
@Named
@SessionScoped
public class Numbers {
    private int i;

    public Numbers() {

    }

    /**
     * Метод предназначен для увеличения переменной цикла.
     * @return возвращает переменную цикла.
     */
    public int add(){
        return ++i;
    }

    /**
     * Метод предназначен для сброса значения переменной цикла.
     */
    public void clear(){
        i = 0;
    }
}
