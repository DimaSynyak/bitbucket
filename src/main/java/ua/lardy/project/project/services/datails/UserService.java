package ua.lardy.project.project.services.datails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lardy.project.project.DAO.author.AuthorDAO;
import ua.lardy.project.project.beans.author.Author;

/**
 * Created by root on 8/13/15.
 */
@Service(value = "userService")
public class UserService implements IUserService {

    @Autowired
    private AuthorDAO authorDAO;

    public UserService() {
        System.out.println(this);
    }

    public Author getAuthor(String login) {
        Author author = null;
        author = authorDAO.getAuthorByLogin(login);
        return author;
    }

    public AuthorDAO getAuthorDAO() {
        return authorDAO;
    }

    public void setAuthorDAO(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }
}
