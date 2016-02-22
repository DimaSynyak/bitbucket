package ua.lardy.project.project.beans.filter;

import org.springframework.beans.factory.annotation.Autowired;
import ua.lardy.project.project.beans.category.CategoryList;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 * Класс контроллер. Связывает отображение и модель.
 * Предназначен для хранения данных фильтрации на странице пользователя.
 * @author Sinyak D.V
 * @version 1.0
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

    /**
     * Метод предназначен для инициализации переменых. Определяет начальное состояние объекта Filter.
     */
    @PostConstruct
    public void init(){
        state = false;
        category = "SELL";
        search = "";
    }

    /**
     *Метод предназначен для обновления отображения.
     * @return возвращает строковое значение, полное имя страницы.
     */
    public String doFilter(){
        return "view.xhtml";
    }

    /**
     * Метод предназначен для возврата состояния checkbox, который находиться на странице view.xhtml.
     * @return возвращает состояние, тип boolean.
     */
    public boolean isState() {
        return state;
    }

    /**
     * Метод предназначен для записи состояния checkbox, который находиться на странице view.xhtml.
     * @param state определяет состояние checkbox, тип boolean.
     */
    public void setState(boolean state) {
        this.state = state;
    }

    /**
     * Метод предназначен для возврата названия рубрики.
     * @return возвращает имя рубрики, тип String.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Метод предназначен для записи имени рубрики.
     * @param category принимает на вход строковые значения, имя рубрики.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Метод предназначен для возврата значения переменной search.
     * @return возвращает строковое значение
     */
    public String getSearch() {
        return search;
    }

    /**
     * Метод предназначен для записи в переменную search значения.
     * @param search принимает на вход строковое значение, имя (или часть имени) автора
     */
    public void setSearch(String search) {
        this.search = search;
    }
}
