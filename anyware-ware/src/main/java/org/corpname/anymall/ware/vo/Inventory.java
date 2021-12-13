package org.corpname.anymall.ware.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Inventory {
    @JsonProperty("inventory")
    private List<InventoryItem> inventoryItems;
}
