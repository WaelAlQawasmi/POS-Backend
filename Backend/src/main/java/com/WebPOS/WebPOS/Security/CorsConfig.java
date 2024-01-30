package com.WebPOS.WebPOS.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Allow your Vue.js frontend origin
        config.addAllowedOrigin("http://127.0.0.1:808");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setAllowCredentials(true); // Set to true to allow credentials
        config.setMaxAge(3600L);
        config.addExposedHeader("X-Get-Header");


        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);

    }
}