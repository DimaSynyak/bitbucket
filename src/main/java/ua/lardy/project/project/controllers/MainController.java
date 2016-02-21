package ua.lardy.project.project.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by root on 8/12/15.
 */
@Controller
public class MainController {

    public MainController() {
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @Secured(value = "ROLE_USER")
    @RequestMapping("/edit")
    public String edit(){
        return "edit";
    }

    @Secured(value = "ROLE_USER")
    @RequestMapping("/view")
    public String view(){
        return "view";
    }
}
