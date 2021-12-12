package org.corpname.anymall.ware.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Inventory {
    // TODO: the 2 annotations(setter and getter) cause the escape objects below
    @JsonProperty("inventory")
    private List<InventoryItem> inventoryItems;

    public void addInventoryItem(InventoryItem inventoryItem) {
        this.inventoryItems.add(inventoryItem);
    }

    public void deleteInventoryItem(InventoryItem inventoryItem) {
        this.inventoryItems.remove(inventoryItem);
    }
}
