package ua.lardy.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ua.lardy.project.services.datails.UserDatail;

/**
 * Created by root on 8/12/15.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class Security extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDatail userDatail;

    public Security() {
        System.out.println(this);
    }

    @Autowired
    private void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDatail);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("login").password("pass").roles("USER");
        auth.userDetailsService(userDatail);
    }

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
