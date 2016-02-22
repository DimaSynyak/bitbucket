package ua.lardy.project.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ua.lardy.project.project.services.datails.UserDatail;

/**
 * Конфигурационный класс. Класс предназначен для настроек аутентификации пользователей.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class Security extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDatail userDatail;

    public Security() {
    }

    /**
     * Метод предназначен для регистрации реализации userDatail.
     * @param auth ссылочная переменная, которая принимает на вход объект AuthenticationManagerBuilder.
     * @throws Exception
     */
    @Autowired
    private void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDatail);
    }

    /**
     * Метод предназначен для конфигурирования системы аутентификации.
     * @param http ссылочная переменная, которая принимает на вход объект HttpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .and();

        http.authorizeRequests()
                .and();



        http.authorizeRequests()
                .antMatchers("USER").access("hasRole('USER')")
                .and();

        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check")
                .defaultSuccessUrl("/view")
                .failureUrl("/login?error")
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .permitAll();

        http.logout()
                .permitAll()
                .logoutUrl("/j_spring_security_logout")
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true);
    }
}
