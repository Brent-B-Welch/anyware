package org.corpname.anymall.ware.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
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

    /**
     * @MethodName: list
     * @Description: list Sku according to the page condition
     * @Param: [params]
     * @Return: org.corpname.anymall.common.utils.R
     * @Author: Beiji Ma
     * @Date: 2021-12-12 23:59
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = wareSkuService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * @MethodName: print the Sku information by given ID
     * @Description: the method's description
     * @Param:
     * @Return:
     * @Author: Beiji Ma
     * @Date: 2021-12-12 23:58
     */
    @GetMapping("/{id}")
    public R info(@PathVariable("id") Long id) {
        WareSkuEntity wareSku = wareSkuService.getById(id);

        return R.ok().put("wareSku", wareSku);
    }

    /**
     * @MethodName: save
     * @Description: save Sku
     * @Param:
     * @Return:
     * @Author: Beiji Ma
     * @Date: 2021-12-13 0:01
     */
    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public R save(@RequestBody WareSkuEntity wareSku) {
        wareSkuService.save(wareSku);

        return R.ok();
    }

    /**
     * @MethodName: update
     * @Description: the method's description
     * @Param: [wareSku]
     * @Return: org.corpname.anymall.common.utils.R
     * @Author: Beiji Ma
     * @Date: 2021-12-13 8:23
     */
    @PutMapping("/{id}")
    @ResponseBody
    public R update(@RequestBody WareSkuEntity wareSku) {
        wareSkuService.updateById(wareSku);
        return R.ok();
    }

    /**
     * @MethodName: delete
     * @Description: the method's description
     * @Param: [ids]
     * @Return: org.corpname.anymall.common.utils.R
     * @Author: Beiji Ma
     * @Date: 2021-12-13 8:22
     */
    @DeleteMapping("/{id}")
    public R delete(@PathVariable("id") Long[] ids) {
        wareSkuService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

    @PostMapping(path = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * @MethodName: batchAddSku
     * @Description: the method's description
     * @Param: [file]
     * @Return: org.corpname.anymall.common.utils.R
     * @Author: Beiji Ma
     * @Date: 2021-12-13 8:22
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
