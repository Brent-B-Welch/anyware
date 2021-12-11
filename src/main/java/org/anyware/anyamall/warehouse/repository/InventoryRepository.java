package org.anyware.anyamall.anyamallwarehouse.repository;

import org.anyware.anyamall.anyamallwarehouse.model.Inventory;
import org.anyware.anyamall.anyamallwarehouse.model.InventoryItem;

public interface InventoryRepository {
    Inventory getAll();

    InventoryItem getOne(Long id);

    void updateWithStock(InventoryItem item, Integer stock);

    void insert(InventoryItem inventoryItem);

    void delete(InventoryItem inventoryItem);
}
