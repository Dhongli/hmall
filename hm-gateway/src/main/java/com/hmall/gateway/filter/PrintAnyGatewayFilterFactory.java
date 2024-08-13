package com.hmall.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author daihongli
 * @version 1.0
 * @ClassName PrintAnyGatewayFilterFactory
 * @Description: TODO
 * @Date 2024-08-13 20:42
 */
@Component
public class PrintAnyGatewayFilterFactory extends AbstractGatewayFilterFactory {
    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            // 获取请求
            ServerHttpRequest request = exchange.getRequest();
            // 编写过滤逻辑
            System.out.println("request.getId() = " + request.getId());
            return chain.filter(exchange);
        };
    }
}
