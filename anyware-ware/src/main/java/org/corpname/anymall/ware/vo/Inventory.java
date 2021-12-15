/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: Inventory
 * @packageName: org.corpname.anymall.ware.vo
 * @description: the model used to import from files, e.g., json format
 * @author: Beiji Ma
 * @date:  2021-12-15 16:28
 **/
package org.corpname.anymall.ware.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Inventory {
    @JsonProperty("inventory")
    private List<InventoryItem> inventoryItems;
}
