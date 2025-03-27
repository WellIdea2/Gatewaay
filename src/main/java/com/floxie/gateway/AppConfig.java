package com.floxie.gateway;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class AppConfig {

  @Value("${cors.allowed-origins}")
  private List<String> allowedOrigins;

  @Bean
  public RouteLocator myRoutes(RouteLocatorBuilder builder) {
    return builder
        .routes()
        .route("nutri-guide", r -> r.path("/nutri-app/v1/**").uri("lb://nutri-guide"))
        .route("authUser", r -> r.path("/api/v1/auth/**").uri("lb://authentication"))
        .route("userDetails", r -> r.path("/api/v1/user-details/**").uri("lb://user-details"))
        .route("user", r -> r.path("/api/v1/user/**").uri("lb://authentication"))
        .build();
  }

  @Bean
  public CorsWebFilter corsFilter() {
    CorsConfiguration corsConfig = new CorsConfiguration();
    corsConfig.setAllowCredentials(true);
    corsConfig.setAllowedOriginPatterns(allowedOrigins);
    corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
    corsConfig.setAllowedHeaders(List.of("*"));

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfig);

    return new CorsWebFilter(source);
  }
}
