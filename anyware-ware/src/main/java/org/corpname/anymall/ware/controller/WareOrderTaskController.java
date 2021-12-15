/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: WareOrderTaskController
 * @packageName: org.corpname.anymall.ware.controller
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:00
 **/
package org.corpname.anymall.ware.controller;

import lombok.extern.slf4j.Slf4j;
import org.corpname.anymall.common.to.WareOrderVo;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.common.utils.R;
import org.corpname.anymall.ware.service.WareOrderTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("ware/ordertask")class WareOrderTaskController {
    @Autowired
    private WareOrderTaskService wareOrderTaskService;

    @GetMapping("/")
    /**
     * @methodName: list
     * @description: TODO
     * @param: [params]
     * @return: org.corpname.anymall.common.utils.R
     * @throws: 
     * @author: Beiji Ma
     * @date: 2021-12-15 16:14
     */
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = wareOrderTaskService.queryPage(params);
        return R.ok().put("page", page);
    }
    
    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * @methodName: lockArticleStockByOrder
     * @description: TODO
     * @param: [vo]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:16
     */
    public R lockArticleStockByOrder(@RequestBody WareOrderVo vo) {
        log.info("vo: {}", vo);
        wareOrderTaskService.lockArticleStockByOrder(vo);
        return R.ok();
    }
}
