/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: WareFeignService
 * @packageName: org.corpname.anymall.product.feign
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:42
 **/
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
    /**
     * @methodName: info
     * @description: TODO
     * @param: [id]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 17:17
     */
    R info(@PathVariable("id") Long id);

    @PostMapping(path="/ware/waresku/stock", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    /**
     * @methodName: getProductWithStock
     * @description: TODO
     * @param: [vos]
     * @return: org.corpname.anymall.common.utils.R
     * @throws: 
     * @author: Beiji Ma
     * @date: 2021-12-15 17:06
     */
    R getProductWithStock(@RequestBody List<ProductWithArticlesVo> vos);

    @PostMapping(path = "/ware/ordertask/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * @methodName: lockArticleStockByOrder
     * @description: TODO
     * @param: [vo]
     * @return: org.corpname.anymall.common.utils.R
     * @throws: 
     * @author: Beiji Ma
     * @date: 2021-12-15 17:06
     */
    R lockArticleStockByOrder(@RequestBody WareOrderVo vo);
}
