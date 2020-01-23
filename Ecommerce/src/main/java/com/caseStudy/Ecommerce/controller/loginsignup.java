package com.caseStudy.Ecommerce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableWebSecurity
@Configuration
public class loginsignup  extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource datasource;
    @Autowired
    public void globalsecurityconfig(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication().dataSource(datasource)
                .usersByUsernameQuery("select email, password ,active from login where email=?")
                .authoritiesByUsernameQuery("select email,password from login where email=?");
    }
    @Override
    protected void configure(HttpSecurity http)  throws Exception{
        http.csrf().disable()
                               .authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                               .antMatchers("/apl/sign").permitAll()
                               .anyRequest().authenticated()
                               .and().httpBasic();
                                http.cors();
    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }


}
