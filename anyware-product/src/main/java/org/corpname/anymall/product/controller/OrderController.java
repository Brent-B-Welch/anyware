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
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = orderService.queryPage(params);
        return R.ok().put("page", page);
    }

    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        OrderInDetailVo orderInDetailVo = orderService.getOrderInDetail(id);
        return R.ok().put("data", orderInDetailVo);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public R createOrder(@Valid @RequestBody List<OrderItemCreationVo> orderVos) {
        log.info("OrderVo: {}", orderVos);
        orderService.createOrder(orderVos);
        return R.ok();
    }

    @GetMapping("/lock/{id}")
    public R lockArticleStockByOrder(@PathVariable("id") Long id) {
        WareOrderVo data = orderService.lockArticleStockByOrder(id);
        return R.ok().put("data", data);
    }

}
