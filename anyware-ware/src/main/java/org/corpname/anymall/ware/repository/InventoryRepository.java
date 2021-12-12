package org.corpname.anymall.ware.repository;


import org.corpname.anymall.ware.model.InventoryItem;
import org.corpname.anymall.ware.vo.InventoryItemView;

import java.util.List;

public interface InventoryRepository {
    List<InventoryItem> findAll();

    InventoryItem getOne(Long id);

    InventoryItem insert(InventoryItem inventoryItem);

    InventoryItemView update(Long id, Integer stock);

    InventoryItemView delete(Long id);
}
