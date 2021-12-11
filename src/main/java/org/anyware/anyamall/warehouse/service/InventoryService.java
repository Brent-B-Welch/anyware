package org.anyware.anyamall.warehouse.service;

import org.anyware.anyamall.warehouse.model.Inventory;
import org.anyware.anyamall.warehouse.model.InventoryItem;

public interface InventoryService {
    Inventory findAll();

    InventoryItem findByArticleId(Long id);

    void updateInventoryItem(InventoryItem item, Integer stock);

    InventoryItem createInventoryItem(InventoryItem inventoryItemRequest);

    void deleteInventoryItem(InventoryItem inventoryItem);
}
