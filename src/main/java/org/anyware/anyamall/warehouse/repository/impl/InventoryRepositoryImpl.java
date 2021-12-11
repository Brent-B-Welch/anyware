package org.anyware.anyamall.warehouse.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.anyware.anyamall.warehouse.model.Inventory;
import org.anyware.anyamall.warehouse.model.InventoryItem;
import org.anyware.anyamall.warehouse.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class InventoryRepositoryImpl implements InventoryRepository {
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private Inventory inventory;


    @Override
    public Inventory getAll() {
        return inventory;
    }

    @Override
    public InventoryItem getOne(Long id) {
        List<InventoryItem> collect = inventory.getInventoryItems().stream().filter(a -> id.equals(a.getArticleId())).collect(Collectors.toList());
        if (!collect.isEmpty()) {
            return collect.get(0);
        }
        return null;
    }

    @Override
    public void updateWithStock(InventoryItem item, Integer stock) {
        item.setStock(stock);
        try {
            mapper.writeValue(new File("src/main/resources/json/inventory.json"), inventory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(InventoryItem inventoryItem) {
        List<InventoryItem> collect = inventory.getInventoryItems().stream().filter(a -> a.getArticleId().equals(inventoryItem.getArticleId())).collect(Collectors.toList());
        if (collect.isEmpty()) {
            inventory.addInventoryItem(inventoryItem);
            try {
                mapper.writeValue(new File("src/main/resources/json/inventory.json"), inventory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(InventoryItem inventoryItem) {
        inventory.deleteInventoryItem(inventoryItem);
        try {
            mapper.writeValue(new File("src/main/resources/json/inventory.json"), inventory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
