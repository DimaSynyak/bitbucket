package ua.lardy.project.services.datails;


import ua.lardy.project.beans.author.Author;

/**
 * Created by root on 8/13/15.
 */
public interface IUserService {
    Author getAuthor(String login);
}
