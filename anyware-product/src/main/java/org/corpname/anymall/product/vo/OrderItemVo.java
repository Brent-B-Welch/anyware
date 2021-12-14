package org.corpname.anymall.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderItemVo {
    private Long id;
    @JsonProperty("order_id")
    private Long orderId;
    @JsonProperty("order_sn")
    private String orderSn;
    @JsonProperty("product_id")
    private Long productId;
    private Integer quantity;
    /**
     * TODO: this will be replaced by Enum
     * INIT(1)
     * IN_PROCESS(2)
     * COMPLETED(3)
     * CANCELLED(4)
     */
    @JsonProperty("order_item_status")
    private Integer orderItemStatus;
}
