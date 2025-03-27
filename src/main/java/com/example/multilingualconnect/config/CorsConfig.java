package com.example.multilingualconnect.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // Allow CORS for all /api endpoints
                .allowedOrigins("*")    // Allow all origins (use specific origins in production, e.g., "http://localhost:8000")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allowed HTTP methods
                .allowedHeaders("*")    // Allow all headers
                .allowCredentials(false);  // Set to true if you need cookies/auth
    }
}