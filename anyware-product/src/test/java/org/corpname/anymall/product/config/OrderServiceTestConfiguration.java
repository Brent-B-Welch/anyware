package org.corpname.anymall.product.config;

import org.corpname.anymall.product.service.OrderService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: OrderServiceTestConfiguration
 * @packageName: org.corpname.anymall.product.config
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date: 2021-12-15 21:58
 **/
@Profile("test")
@Configuration
public class OrderServiceTestConfiguration {
    @Bean
    @Primary
    public OrderService orderService() {
        return Mockito.mock(OrderService.class);
    }
}
