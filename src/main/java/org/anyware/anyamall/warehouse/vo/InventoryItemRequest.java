package org.anyware.anyamall.anyamallwarehouse.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
public class InventoryItemRequest {
    @NotNull
    @JsonProperty("art_id")
    private Long artId;
    @NotEmpty
    private String name;
    @NotNull
    private Integer stock;
}
