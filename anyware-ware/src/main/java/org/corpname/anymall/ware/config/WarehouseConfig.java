package org.corpname.anymall.ware.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.corpname.anymall.ware.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@Slf4j
public class WarehouseConfig {
    @Autowired
    private ObjectMapper mapper;

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
}
