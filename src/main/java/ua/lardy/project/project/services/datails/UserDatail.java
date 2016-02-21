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
import ua.lardy.project.project.beans.author.enums.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 8/13/15.
 */
@Service
public class UserDatail implements UserDetailsService {
    @Autowired
    private UserService userService;


    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Author author = userService.getAuthor(login);
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(Role.ROLE_USER.name()));
        UserDetails userDetails = new User(author.getName(), author.getPassword(), roles);
        return userDetails;
    }


}
