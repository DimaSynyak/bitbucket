package ua.lardy.project.project.DAO.author;

import ua.lardy.project.project.beans.author.Author;

import java.util.List;

/**
 * @author Sinyak D.V.
 * @version 1.0
 */
public interface IAuthorDAO {
    Author getAuthorByName(String name);
    Author getAuthorByLogin(String login);
    List<Author> getAuthorsByName(String login);
}
