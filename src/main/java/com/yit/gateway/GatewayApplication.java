package com.yit.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		
		return builder.routes()
			      .route(r ->r
			    		  .path("/getProduct")
			    		  .uri("http://catalog-git:8080")
			    		  .id("Product"))
			      .route(r -> r
			    		  .path("/getCart")
			    		  .filters(f -> f.prefixPath("/api"))
			    		  .uri("http://cart-git:8080")
			    		  .id("Cart"))
			      .route(r -> r
			    		  .path("/addToCart")
			    		  .filters(f -> f.prefixPath("/api"))
			    		  .uri("http://cart-git:8080")
			    		  .id("Cart"))
			      .route(r -> r
			    		  .path("/deleteItem")
			    		  .filters(f -> f.prefixPath("/api"))
			    		  .uri("http://cart-git:8080")
			    		  .id("Cart"))
			    .build();
	
    }
}
