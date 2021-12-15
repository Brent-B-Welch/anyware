/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: OrderController
 * @packageName: org.corpname.anymall.product.controller
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:31
 **/
package org.corpname.anymall.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.corpname.anymall.common.to.OrderItemCreationVo;
import org.corpname.anymall.common.to.WareOrderVo;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.common.utils.R;
import org.corpname.anymall.product.service.OrderService;
import org.corpname.anymall.product.vo.OrderInDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("order/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    /**
     * @methodName: list
     * @description: list all Orders
     * @param: [params]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:33
     */
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = orderService.queryPage(params);
        return R.ok().put("page", page);
    }

    @GetMapping("/info/{id}")
    /**
     * @methodName: info
     * @description: inspect an Order by given Order id
     * @param: [id]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:32
     */
    public R info(@PathVariable("id") Long id) {
        OrderInDetailVo orderInDetailVo = orderService.getOrderInDetail(id);
        return R.ok().put("data", orderInDetailVo);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * @methodName: createOrder
     * @description: create Orders in a batch way
     * @param: [orderVos]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:32
     */
    public R createOrder(@Valid @RequestBody List<OrderItemCreationVo> orderVos) {
        log.info("OrderVo: {}", orderVos);
        orderService.createOrder(orderVos);
        return R.ok();
    }

    @GetMapping("/lock/{id}")
    /**
     * @methodName: lockArticleStockByOrder
     * @description: lock available stock of Articles with given Order id
     * @param: [id]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:33
     */
    public R lockArticleStockByOrder(@PathVariable("id") Long id) {
        WareOrderVo data = orderService.lockArticleStockByOrder(id);
        return R.ok().put("data", data);
    }

}
