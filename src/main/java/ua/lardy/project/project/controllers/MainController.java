package ua.lardy.project.project.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Класс контроллер. Связывает отображение и модель объектов.
 * Предназначен связать отображение и аутентификацию пользователей.
 * @author Sinyak D.V.
 * @version 1.0
 */
@Controller
public class MainController {

    public MainController() {
    }

    /**
     * Метод предназначен возвращать имя файла для редиректа.
     * @return возвращает строковое значение.
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * Метод предназначен возвращать имя файла для редиректа.
     * @return возвращает строковое значение.
     */
    @Secured(value = "ROLE_USER")
    @RequestMapping("/edit")
    public String edit(){
        return "edit";
    }

    /**
     * Метод предназначен возвращать имя файла для редиректа.
     * @return возвращает строковое значение.
     */
    @Secured(value = "ROLE_USER")
    @RequestMapping("/view")
    public String view(){
        return "view";
    }
}
