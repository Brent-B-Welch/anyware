package org.corpname.anymall.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("oms_order_item")
public class OrderItemEntity {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long orderId;
    private String orderSn;
    private Long productId;
    private Integer quantity;
    /**
     * TODO: this will be replaced by Enum
     * INIT(1)
     * IN_PROCESS(2)
     * COMPLETED(3)
     * CANCELLED(4)
     */
    private Integer orderItemStatus;
}
