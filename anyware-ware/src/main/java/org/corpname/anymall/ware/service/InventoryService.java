package org.corpname.anymall.ware.service;

import org.corpname.anymall.ware.model.InventoryItem;
import org.corpname.anymall.ware.vo.InventoryItemView;

import java.util.List;

public interface InventoryService {
    List<InventoryItemView> getAll();

    InventoryItemView findByArtId(Long id);

    InventoryItemView createInventoryItem(InventoryItem inventoryItem);

    InventoryItemView updateInventoryItem(Long id, Integer stock);

    InventoryItemView deleteByArtId(Long id);
}
