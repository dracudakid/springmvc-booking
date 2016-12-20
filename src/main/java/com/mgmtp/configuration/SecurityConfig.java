package com.mgmtp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Tan Dat on 19/12/2016.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    final private String ROLE_ADMIN = "ADMIN";
    final private String ROLE_USER = "USER";
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("123456").roles(ROLE_USER).and()
                .withUser("admin").password("123456").roles(ROLE_USER, ROLE_ADMIN);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/logout", "/public/**" ).permitAll()
                .antMatchers("/admin/**").hasRole(ROLE_ADMIN)
                .anyRequest().hasRole(ROLE_USER)
                .and()
                .formLogin()
                .loginPage("/login").failureUrl("/?login&error")
                .usernameParameter("email").passwordParameter("password")
                .and().logout().logoutSuccessUrl("/");
    }
}
