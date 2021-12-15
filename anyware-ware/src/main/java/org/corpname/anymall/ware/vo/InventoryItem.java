/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: InventoryItem
 * @packageName: org.corpname.anymall.ware.vo
 * @description: the model used to import from files, e.g., json format
 * @author: Beiji Ma
 * @date:  2021-12-15 16:29
 **/
package org.corpname.anymall.ware.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItem {
    @JsonProperty("art_id")
    private Long articleId;
    private String name;
    private Integer stock;
}