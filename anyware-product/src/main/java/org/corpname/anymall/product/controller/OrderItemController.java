package org.corpname.anymall.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.common.utils.R;
import org.corpname.anymall.product.entity.OrderItemEntity;
import org.corpname.anymall.product.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("order/orderitem")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = orderItemService.queryPage(params);
        return R.ok().put("page", page);
    }

    @GetMapping("/{id}")
    public R getOrderDetail(@PathVariable("id") Long id) {
        OrderItemEntity orderItemEntity = orderItemService.getById(id);

        return R.ok().put("data", orderItemEntity);
    }
}
