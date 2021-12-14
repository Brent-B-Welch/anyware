package org.corpname.anymall.product.feign;

import org.corpname.anymall.common.to.ProductWithArticlesVo;
import org.corpname.anymall.common.to.WareOrderVo;
import org.corpname.anymall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "anyware-ware")
public interface WareFeignService {
    @GetMapping("/ware/waresku/{id}")
    R info(@PathVariable("id") Long id);

    @PostMapping(path="/ware/waresku/stock", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    R getProductWithStock(@RequestBody List<ProductWithArticlesVo> vos);

    @PostMapping(path = "/ware/ordertask/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    R lockArticleStockByOrder(@RequestBody WareOrderVo vo);
}
