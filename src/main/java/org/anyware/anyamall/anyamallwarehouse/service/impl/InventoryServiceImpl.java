package org.anyware.anyamall.anyamallwarehouse.service.impl;

import org.anyware.anyamall.anyamallwarehouse.model.Inventory;
import org.anyware.anyamall.anyamallwarehouse.model.InventoryItem;
import org.anyware.anyamall.anyamallwarehouse.repository.InventoryRepository;
import org.anyware.anyamall.anyamallwarehouse.service.InventoryService;
import org.anyware.anyamall.anyamallwarehouse.vo.InventoryItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public Inventory findAll() {
        Inventory inventory = inventoryRepository.getAll();
        return inventory;
    }

    @Override
    public InventoryItem findByArticleId(Long id) {
        InventoryItem inventoryItem = inventoryRepository.getOne(id);
        return inventoryItem;
    }

    @Override
    public void updateInventoryItem(InventoryItem item, Integer stock) {
        inventoryRepository.updateWithStock(item, stock);
    }

    @Override
    public InventoryItem createInventoryItem(InventoryItem inventoryItem) {
        inventoryRepository.insert(inventoryItem);
        return inventoryItem;
    }

    @Override
    public void deleteInventoryItem(InventoryItem inventoryItem) {
        inventoryRepository.delete(inventoryItem);
    }

}
