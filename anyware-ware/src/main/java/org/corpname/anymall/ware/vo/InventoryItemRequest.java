package org.corpname.anymall.ware.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryItemRequest {
    @NotNull(message = "art_id is empty")
    @JsonProperty("art_id")
    private Long artId;
    @NotEmpty(message = "name is empty")
    private String name;
    @NotNull(message = "stock is empty")
    private Integer stock;
}
