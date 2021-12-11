package org.anyware.anyamall.warehouse.repository;


import org.anyware.anyamall.warehouse.model.Inventory;
import org.anyware.anyamall.warehouse.model.InventoryItem;

public interface InventoryRepository {
    Inventory getAll();

    InventoryItem getOne(Long id);

    void updateWithStock(InventoryItem item, Integer stock);

    void insert(InventoryItem inventoryItem);

    void delete(InventoryItem inventoryItem);
}
