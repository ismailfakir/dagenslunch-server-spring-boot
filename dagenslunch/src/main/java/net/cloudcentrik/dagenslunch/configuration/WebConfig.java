package net.cloudcentrik.dagenslunch.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/webjars/**","/img/**", "/css/**", "/js/**","/vendor/**")
                .addResourceLocations("/webjars/","classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/","classpath:/static/vendor/");

        /* adding resource for swagger*/
        addSwaggerResources(registry);
    }

    /* adding resource for swagger*/
    public void addSwaggerResources(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}