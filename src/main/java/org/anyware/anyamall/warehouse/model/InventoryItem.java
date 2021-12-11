package org.anyware.anyamall.anyamallwarehouse.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InventoryItem {
    @JsonProperty("art_id")
    private Long articleId;
    private String name;
    private Integer stock;
}
