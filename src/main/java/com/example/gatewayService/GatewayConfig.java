package com.example.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("PostService", r -> r.path("/posts/**")
                        .uri("http://localhost:8081")) // Post Service URL
                .route("UserService", r -> r.path("/users/**")
                        .uri("http://localhost:8082")) // User Service URL
                .build();
    }
}
