package com.radebit.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rade
 * @date 2020/9/10 10:12 下午
 * @url https://blog.radebit.com
 * 说明：
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route(
                "path_route_radebit",
                r -> r.path("/safenews")
                        .uri("https://www.radebit.com/web/article/category/safenews"))
                .build();
        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route(
                "path_route_radebit2",
                r -> r.path("/safebug")
                        .uri("https://www.radebit.com/web/article/category/safebug"))
                .build();
        return routes.build();
    }
}
