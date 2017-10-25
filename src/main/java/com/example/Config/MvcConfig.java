package com.example.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/resources/static/", "classpath:/public/", "classpath:/resources/public" };

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


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);

    }

    /*
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        registry.addResourceHandler("/stylesheets/**").addResourceLocations("/stylesheets/");
        registry.addResourceHandler("/scripts/**").addResourceLocations("/scripts/");
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
     */


}
