package com.radebit.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author Rade
 * @date 2020/9/14 12:55 下午
 * @url https://blog.radebit.com
 * 说明：
 */
@Component
@Slf4j
public class SysLogGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("===== " + new Date() + " [come in] SysLogGateWayFilter =====");
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (username == null) {
            log.error("===== " + new Date() + " [username is null] 用户名为空！ =====");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
