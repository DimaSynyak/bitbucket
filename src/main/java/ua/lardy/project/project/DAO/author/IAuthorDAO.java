package ua.lardy.project.project.DAO.author;

import ua.lardy.project.project.beans.author.Author;

import java.util.List;

/**
 * Created by root on 8/13/15.
 */
public interface IAuthorDAO {
    void insertAuthor(Author author);
    Author getAuthorByName(String name);
    Author getAuthorByLogin(String login);
    List<Author> getAuthorsByName(String login);
}
