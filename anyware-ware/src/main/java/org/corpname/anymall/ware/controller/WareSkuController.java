/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: WareSkuController
 * @packageName: org.corpname.anymall.ware.controller
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:19
 **/
package org.corpname.anymall.ware.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.corpname.anymall.common.to.ProductStockVo;
import org.corpname.anymall.common.to.ProductWithArticlesVo;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.common.utils.R;
import org.corpname.anymall.ware.vo.Inventory;
import org.corpname.anymall.ware.entity.WareSkuEntity;
import org.corpname.anymall.ware.service.WareSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("ware/waresku")
@Slf4j
public class WareSkuController {

    @Autowired
    private WareSkuService wareSkuService;
    @Autowired
    private ObjectMapper mapper;

    @RequestMapping("/")
    /**
     * @methodName: list
     * @description: list Sku according to the page condition
     * @param: [params]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:35
     */
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = wareSkuService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("/{id}")
    /**
     * @methodName: info
     * @description: print the Sku information by given ID
     * @param: [id]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:35
     */
    public R info(@PathVariable("id") Long id) {
        WareSkuEntity data = wareSkuService.getById(id);

        return R.ok().put("data", data);
    }

    /**
     * @methodsName: getProductWithStock
     * @description: TODO
     * @param: [vos]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 15:57
     */
    @PostMapping(path="/stock", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R getProductWithStock(@RequestBody List<ProductWithArticlesVo> vos) {
        log.info("ProductWithArticlesVo: {}", vos);
        List<ProductStockVo> productStockVos = wareSkuService.getProductWithStock(vos);
        return R.ok().put("data", productStockVos);
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * @methodName: save
     * @description: TODO
     * @param: [wareSku]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:35
     */
    public R save(@RequestBody WareSkuEntity wareSku) {
        wareSkuService.save(wareSku);

        return R.ok();
    }

    /**
     * @methodName: update
     * @description: TODO
     * @param: [wareSku]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:16
     */
    @PutMapping("/")
    @ResponseBody
    public R update(@RequestBody WareSkuEntity wareSku) {
        wareSkuService.updateById(wareSku);
        return R.ok();
    }

    /**
     * @methodName: delete
     * @description: TODO
     * @param: [ids]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:17
     */
    @DeleteMapping("/{id}")
    public R delete(@PathVariable("id") Long[] ids) {
        wareSkuService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

    @PostMapping(path = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * @methodName: batchAddSku
     * @description: the method is used to import inventory items as a batch.
     *               TODO: It's preferable to move the logic into service layer in the future.
     * @param: [file]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:17
     */
    public R batchAddSku(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(
                        new InputStreamReader(file.getInputStream()));

                Inventory inventory = mapper.readValue(reader, Inventory.class);
                log.info("inventory: {}", inventory);
                List<WareSkuEntity> collect = inventory.getInventoryItems()
                        .stream()
                        .map(inventoryItem -> WareSkuEntity.builder()
                                .artId(inventoryItem.getArticleId())
                                .name(inventoryItem.getName())
                                .stock(inventoryItem.getStock())
                                .build()
                        ).collect(Collectors.toList());
                log.info("collect: {}", collect);
                wareSkuService.saveBatch(collect);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                IOUtils.closeQuietly(reader);
            }
        }
        return R.ok();
    }
}
