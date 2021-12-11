package org.anyware.anyamall.warehouse.service.impl;

import org.anyware.anyamall.warehouse.model.Inventory;
import org.anyware.anyamall.warehouse.model.InventoryItem;
import org.anyware.anyamall.warehouse.repository.InventoryRepository;
import org.anyware.anyamall.warehouse.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public Inventory findAll() {
        return inventoryRepository.getAll();
    }

    @Override
    public InventoryItem findByArticleId(Long id) {
        return inventoryRepository.getOne(id);
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
