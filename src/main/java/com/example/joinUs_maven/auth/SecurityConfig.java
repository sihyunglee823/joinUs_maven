package com.example.joinUs_maven.auth;

import com.example.joinUs_maven.service.ExService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final ExService exService;

    /**
     * set rules for login
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/userAccess").hasRole("USER").antMatchers("/signUp").anonymous().and().formLogin().and().cors().and().csrf().disable();
    }

    /**
     * Method for login authentication processing
     * @param auth
     * @throws Exception
     */

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(exService).passwordEncoder(new BCryptPasswordEncoder());
    }

}