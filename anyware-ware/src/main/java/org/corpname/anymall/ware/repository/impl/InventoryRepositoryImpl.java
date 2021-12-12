package org.corpname.anymall.ware.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.corpname.anymall.ware.model.Inventory;
import org.corpname.anymall.ware.model.InventoryItem;
import org.corpname.anymall.ware.repository.InventoryRepository;
import org.corpname.anymall.ware.vo.InventoryItemView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class InventoryRepositoryImpl implements InventoryRepository {
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private Inventory inventory;

    @Override
    public List<InventoryItem> findAll() {
        return inventory.getInventoryItems();
    }

    @Override
    public InventoryItem getOne(Long id) {
        List<InventoryItem> collect = inventory.getInventoryItems().stream().filter(item -> id.equals(item.getArticleId())).collect(Collectors.toList());
        if (!collect.isEmpty()) {
            return collect.get(0);
        }
        return null;
    }

    @Override
    public InventoryItem insert(InventoryItem inventoryItem) {
        List<InventoryItem> collect = inventory.getInventoryItems()
                .stream()
                .filter(it -> it.getArticleId().equals(inventoryItem.getArticleId()))
                .collect(Collectors.toList());
        if (collect.isEmpty()) {
            inventory.addInventoryItem(inventoryItem);
            flushToDb();
            return inventoryItem;
        } else {
            return collect.get(0);
        }
    }

    @Override
    public InventoryItemView update(Long id, Integer stock) {
        List<InventoryItem> collect = inventory.getInventoryItems()
                .stream()
                .filter(item -> item.getArticleId().equals(id))
                .collect(Collectors.toList());
        log.info("Current InventoryItem: {}", collect);
        if (collect.size() == 1) {
            InventoryItem item = collect.get(0);
            item.setStock(stock);
            flushToDb();
            return InventoryItemView.builder()
                    .artId(item.getArticleId())
                    .name(item.getName())
                    .stock(item.getStock())
                    .build();
        } else {
            return null;
        }
    }

    @Override
    public InventoryItemView delete(Long id) {
        List<InventoryItem> collect = inventory.getInventoryItems().stream().filter(item -> id.equals(item.getArticleId())).collect(Collectors.toList());
        if (collect.size() == 1) {
            InventoryItem item = collect.get(0);
            inventory.deleteInventoryItem(item);
            flushToDb();
            return InventoryItemView.builder()
                    .artId(item.getArticleId())
                    .name(item.getName())
                    .stock(item.getStock())
                    .build();
        }
        return null;
    }

    private void flushToDb() {
        try {
            log.info("Sync inventory items to persistence.");
            mapper.writeValue(new File("src/main/resources/json/inventory.json"), inventory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
