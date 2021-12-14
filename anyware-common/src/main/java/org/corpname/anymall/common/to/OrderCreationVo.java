package org.corpname.anymall.common.to;

import lombok.Data;

import java.util.List;

@Data
public class OrderCreationVo {
    List<OrderItemCreationVo> orderItems;
}
