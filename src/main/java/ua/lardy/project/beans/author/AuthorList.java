package ua.lardy.project.beans.author;

import org.springframework.beans.factory.annotation.Autowired;
import ua.lardy.project.DAO.author.AuthorDAO;
import ua.lardy.project.beans.author.Author;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 8/13/15.
 */
@Named
@SessionScoped
public class AuthorList {
    private List<Author> authors;
    private Author author;

    @Autowired
    private AuthorDAO authorDAO;

    public List<Author> getAuthors(){
        authors = authorDAO.getAuthorList();

        return authors;
    }

    public Author getAuthorByLogin(String login){
        author = authorDAO.getAuthorByLogin(login);

        return author;
    }

    public List<Author> getAuthorsByName(String name){
        List<Author> authorList = authorDAO.getAuthorsByName(name);

        return authorList;
    }


    public Author getAuthorByName(String name){
        Author author = authorDAO.getAuthorByName(name);

        return author;
    }

}
