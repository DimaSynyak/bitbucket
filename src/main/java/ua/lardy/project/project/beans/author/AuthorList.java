package ua.lardy.project.project.beans.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ua.lardy.project.project.DAO.author.AuthorDAO;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;
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

    public AuthorList(){}

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

    public int getAuthorId(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Author author = getAuthorByName(name);
        return author.getId();
    }

}
