package com.example.Config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    /*@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }*/


    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(paths()).build();
    }

    private Predicate<String> paths() {
        return or(regex("/"),
                regex("/helloworld"));
                /*regex("/users/add"),
                regex("/users/add.*"),
                regex("/users/remove.*"),
                regex("/hello"),
                regex("/user"),
                regex("/user.*"),
                regex("/testUser.*"),
                regex("/testUser/status.*"),
                regex("/customers.*"),
                regex("/customers/add.*"),
                regex("/customers/register.*"),
                regex("/jobs.*"),
                regex("customers/remove.*"));*/
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("My Swagger API documentation")
                .description("My Swagger API documentation for automation QAis")
                .termsOfServiceUrl("http://rest-service.com")
                .contact("genchevskiy.gepur@gmail.com").license("JavaInUse License")
                .licenseUrl("javainuse@gmail.com").version("1.0").build();
    }




    /*@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                .paths(PathSelectors.ant("/foos/*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "My REST API",
                "Some custom description of API.",
                "API TOS",
                "Terms of service",
                "myeaddress@company.com",
                "License of API",
                "API license URL");
        return apiInfo;
    }*/


}
