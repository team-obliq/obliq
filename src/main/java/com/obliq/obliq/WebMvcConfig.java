package com.obliq.obliq;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig {

    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry
                .addResourceHandler("/static/**")
                .addResourceLocations("/static/geom.png")
                .setCachePeriod(0);

    }
}
