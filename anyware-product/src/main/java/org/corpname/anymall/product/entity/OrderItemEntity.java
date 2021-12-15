/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: OrderItemEntity
 * @packageName: org.corpname.anymall.product.entity
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:40
 **/
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

    /**
     * id
     */
    private Long id;
    /**
     * order_id
     */
    private Long orderId;
    /**
     * order_sn
     */
    private String orderSn;
    /**
     * product_id
     */
    private Long productId;
    /**
     * quantity
     */
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
