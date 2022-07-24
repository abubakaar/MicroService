package com.fitness.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * API Gateway Configuration Class
 */
@Configuration
public class ApiGatewayConfiguration {

    /**
     * @param builder Route Locator Builder
     * @return Route Locator
     */
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/")
                        .uri("lb://MICROSERVICE-2"))

                .route(p -> p.path("/class/**")
                        .uri("lb://ClassService"))
                .build();
    }
}
