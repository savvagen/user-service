package com.example.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/greeting").setViewName("greeting");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/users").setViewName("usersList");
        registry.addViewController("/users/*").setViewName("showUser");
        registry.addViewController("/signUp").setViewName("signUp");
        registry.addViewController("/users/register").setViewName("register");
        registry.addViewController("/login").setViewName("login");
        /*registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");*/
    }


}
