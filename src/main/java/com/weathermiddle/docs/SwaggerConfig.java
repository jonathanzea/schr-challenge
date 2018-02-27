package com.weathermiddle.docs;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import com.wordnik.swagger.model.ApiInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableSwagger
@ComponentScan("com.weathermiddle.controller")
public class SwaggerConfig {

    public static final String DEFAULT_INCLUDE_PATTERNS = "/example/.*";

    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean 
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(apiInfo())
                .includePatterns(DEFAULT_INCLUDE_PATTERNS);
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot REST APIs",
                "The APIs here retrieves the temperature from an external serivice (OpenWheatherMap) creating a 'middleware' service built with Spring Boot and other helpful libraries",
                "Jonathan Zea - Java Developer",
                "zeta_jonathan@hotmail.com",
                "Venezuela",
                "https://openweathermap.org/"
        );
        return apiInfo;
    }
}
