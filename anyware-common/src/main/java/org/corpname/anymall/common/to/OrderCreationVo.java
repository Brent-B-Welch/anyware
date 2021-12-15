/**
 * @version: V1.0
 * @author: Beiji Ma
 * @className: OrderCreationVo
 * @packageName: ${PACKAGE_NAME}
 * @description: the method's description
 * @data: 2021-12-15 15:39
 **/
package org.corpname.anymall.common.to;

import lombok.Data;

import java.util.List;

@Data
public class OrderCreationVo {

    /**
     * @MethodName:
     * @Description: the method's description
     * @param:
     * @Return:
     * @author: Beiji Ma
     * @Date: 2021-12-15 15:41
    */
    public OrderCreationVo(List<OrderItemCreationVo> orderItems) {
        this.orderItems = orderItems;
    }

    List<OrderItemCreationVo> orderItems;
}
