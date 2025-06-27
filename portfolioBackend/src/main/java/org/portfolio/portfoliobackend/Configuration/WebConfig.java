package org.portfolio.portfoliobackend.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                // Allow for Admin Dashboard requests (GET, POST, DELETE)
                registry.addMapping("/api/v1/admin/**")
                        .allowedOrigins("http://localhost:5500")
                        .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS")
                        .allowedHeaders("*")
                        .allowedOriginPatterns("*")
                        .allowCredentials(true);

                // Allow for Contact Message form submission (POST only)
                registry.addMapping("/api/v1/contact/**")
                        .allowedOrigins("http://localhost:5500")
                        .allowedMethods("POST")
                        .allowedHeaders("*")
                        .allowedOriginPatterns("*")
                        .allowCredentials(true);

            }
        };
    }

}
