package com.mgmtp.configuration;

import com.mgmtp.service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private EmployeeDetailsService employeeDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(employeeDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String ROLE_ADMIN = "ADMIN";
        String ROLE_USER = "USER";

        http
                .authorizeRequests()
                .antMatchers("/", "/logout", "/public/**" ).permitAll()
                .antMatchers("/admin/**").hasRole(ROLE_ADMIN)
                .anyRequest().hasRole(ROLE_USER)
                .and()
                .formLogin()
                .loginPage("/").failureUrl("/?login&error")
                .usernameParameter("email").passwordParameter("password")
                .and().logout().logoutSuccessUrl("/")
                .and().csrf().disable();
    }
}
