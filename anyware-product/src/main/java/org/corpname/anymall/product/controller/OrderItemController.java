/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: OrderItemController
 * @packageName: org.corpname.anymall.product.controller
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:36
 **/
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
    /**
     * @methodName: list
     * @description: list all OrderItems
     * @param: [params]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:36
     */
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = orderItemService.queryPage(params);
        return R.ok().put("page", page);
    }

    @GetMapping("/{id}")
    /**
     * @methodName: getOrderDetail
     * @description: get Order in detail by given id, including the content of Products
     * @param: [id]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:36
     */
    public R getOrderDetail(@PathVariable("id") Long id) {
        OrderItemEntity orderItemEntity = orderItemService.getById(id);

        return R.ok().put("data", orderItemEntity);
    }
}
