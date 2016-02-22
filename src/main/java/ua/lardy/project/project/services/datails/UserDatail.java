package ua.lardy.project.project.services.datails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.lardy.project.project.beans.author.Author;
import ua.lardy.project.project.beans.author.AuthorList;
import ua.lardy.project.project.beans.author.enums.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, котроый описывает механизм аутентификации пользователей.
 * @author Sinyak D.V.
 * @version 1.0
 */
@Service
public class UserDatail implements UserDetailsService {
    @Autowired
    private AuthorList authorList;

    /**
     * Метод предназначен возвратить настройки пользователя.
     * @param login строковая переменная, которая принимает на вход логин пользователя.
     * @return Возвращает объект конфигурации пользователя.
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Author author = authorList.getAuthor(login);
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(Role.ROLE_USER.name()));
        UserDetails userDetails = new User(author.getName(), author.getPassword(), roles);
        return userDetails;
    }


}
