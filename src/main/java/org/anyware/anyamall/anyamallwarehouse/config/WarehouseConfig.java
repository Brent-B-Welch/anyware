package org.anyware.anyamall.anyamallwarehouse.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.anyware.anyamall.anyamallwarehouse.model.Inventory;
import org.anyware.anyamall.anyamallwarehouse.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@Slf4j
public class WarehouseConfig {
    @Autowired
    ObjectMapper mapper;

    @Bean
    public Inventory inventory() {
        Inventory inventory = null;
        try {
            inventory = mapper.readValue(this.getClass().getResourceAsStream("/json/inventory.json"), Inventory.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("Inventory: {}", inventory);
        return inventory;
    }

    @Bean
    public Products products() {
        Products products = null;
        try {
            products = mapper.readValue(this.getClass().getResourceAsStream("/json/products.json"), Products.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("Products: {}", products);
        return products;
    }
}
