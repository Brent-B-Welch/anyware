package org.corpname.anymall.ware.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryItemView {
    @JsonProperty("art_id")
    private Long artId;
    private String name;
    private Integer stock;
}
