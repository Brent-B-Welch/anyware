package org.anyware.anyamall.anyamallwarehouse.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
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
