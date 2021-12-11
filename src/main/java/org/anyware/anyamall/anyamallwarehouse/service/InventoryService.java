package org.anyware.anyamall.anyamallwarehouse.service;

import org.anyware.anyamall.anyamallwarehouse.model.Inventory;
import org.anyware.anyamall.anyamallwarehouse.model.InventoryItem;

public interface InventoryService {
    Inventory findAll();

    InventoryItem findByArticleId(Long id);

    void updateInventoryItem(InventoryItem item, Integer stock);

    InventoryItem createInventoryItem(InventoryItem inventoryItemRequest);

    void deleteInventoryItem(InventoryItem inventoryItem);
}
