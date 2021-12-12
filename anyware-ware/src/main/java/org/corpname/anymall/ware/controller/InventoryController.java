package org.corpname.anymall.ware.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.corpname.anymall.ware.model.InventoryItem;
import org.corpname.anymall.ware.service.InventoryService;
import org.corpname.anymall.ware.vo.InventoryItemRequest;
import org.corpname.anymall.ware.vo.InventoryItemView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/inventory")
@Api(tags = "Inventory")
@Slf4j
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @ApiOperation("Inventory List")
    @GetMapping("/")
    public List<InventoryItemView> getInventory() {
        return inventoryService.getAll();
    }

    /**
     * @MethodName: getInventoryItem
     * @Description: the method is to get an InventoryItem by given Article Id.
     * @Param: [id]
     * @Return: org.corpname.anymall.ware.vo.InventoryItemView
     * @Author: Beiji Ma
     * @Date: 2021-12-12 16:27
    */
    @GetMapping("/{id}")
    public InventoryItemView getInventoryItem(@PathVariable("id") Long id) {
        log.info("Receive Article ID {}", id);
        return inventoryService.findByArtId(id);
    }

    /**
     * @MethodName: createInventoryItemWithBindingResult
     * @Description: the method is to create an InventoryItem with given payload.
     *
     * TODO: you could find the open issue regarding the
     *   mismatching of the fields' names between Java bean
     *   and HttpRequest payload here:
     *     https://github.com/spring-projects/spring-framework/issues/18012
     *   and the some short term mitigation is here:
     *     https://api.slack.com/interactivity/slash-commands
     *   or use "artId" for the field name of payload
     *
     * @Param: [inventoryItemRequest]
     * @Return: org.corpname.anymall.ware.vo.InventoryItemView
     * @Author: Beiji Ma
     * @Date: 2021-12-12 16:15
    */
    @PostMapping(path = "/", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryItemView createInventoryItemWithBindingResult(@Valid InventoryItemRequest inventoryItemRequest, BindingResult result) {
        log.info("Receive new InventoryItem {}", inventoryItemRequest);
        if (result.hasErrors()) {
            log.warn("Binding Errors: {}", result);
            return null;
        }

        InventoryItem inventoryItem = InventoryItem.builder().name(inventoryItemRequest.getName())
                .articleId(inventoryItemRequest.getArtId())
                .stock(inventoryItemRequest.getStock())
                .build();

        return inventoryService.createInventoryItem(inventoryItem);
    }

    /**
     * @MethodName: createInventoryItemWithoutBindResult
     * @Description: the method is to create an InventoryItem with given json data.
     * @Param: [InventoryItemRequest]
     * @Return: InventoryItemView
     * @Author: Beiji Ma
     * @Date: 2021-12-12 18:27
    */
    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryItemView createInventoryItemWithoutBindResult(@Valid @RequestBody InventoryItemRequest inventoryItemRequest) {
        log.info("Receive new InventoryItem {}", inventoryItemRequest);
        InventoryItem inventoryItem = InventoryItem.builder().name(inventoryItemRequest.getName())
                .articleId(inventoryItemRequest.getArtId())
                .stock(inventoryItemRequest.getStock())
                .build();

        return inventoryService.createInventoryItem(inventoryItem);
    }

    /**
     * @MethodName: updateByArtIdWithStock
     * @Description: the method is to update InventoryItem with given stock
     * @Param: [id, stock]
     * @Return: org.corpname.anymall.ware.vo.InventoryItemView
     * @Author: Beiji Ma
     * @Date: 2021-12-12 19:01
     */
    @PutMapping("/{id}")
    @ResponseBody
    public InventoryItemView updateByArtIdWithStock(@PathVariable("id") Long id, @RequestParam Integer stock) {
        log.info("Update inventory {} with {}", id, stock);
        return inventoryService.updateInventoryItem(id, stock);
    }

    /**
     * @MethodName: deleteByArtId
     * @Description: the method is used to delete an InventoryItem by given Article ID
     * @Param: [id]
     * @Return: org.corpname.anymall.ware.vo.InventoryItemView
     * @Author: Beiji Ma
     * @Date: 2021-12-12 19:21
    */
    @DeleteMapping("/{id}")
    public InventoryItemView deleteByArtId(@PathVariable("id") Long id) {
        log.info("Delete an InventoryItem: {}", id);
        return inventoryService.deleteByArtId(id);
    }
}
