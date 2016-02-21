package ua.lardy.project.project.services.datails;


import ua.lardy.project.project.beans.author.Author;

/**
 * Created by root on 8/13/15.
 */
public interface IUserService {
    Author getAuthor(String login);
}
