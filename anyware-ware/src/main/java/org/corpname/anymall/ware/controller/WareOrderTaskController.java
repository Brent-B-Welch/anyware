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
@RequestMapping("ware/ordertask")
public class WareOrderTaskController {
    @Autowired
    private WareOrderTaskService wareOrderTaskService;

    @GetMapping("/")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = wareOrderTaskService.queryPage(params);
        return R.ok().put("page", page);
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public R lockArticleStockByOrder(@RequestBody WareOrderVo vo) {
        log.info("vo: {}", vo);
        wareOrderTaskService.lockArticleStockByOrder(vo);
        return R.ok();
    }
}
