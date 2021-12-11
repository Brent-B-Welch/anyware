package org.anyware.anyamall.warehouse.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.anyware.anyamall.warehouse.model.Inventory;
import org.anyware.anyamall.warehouse.model.InventoryItem;
import org.anyware.anyamall.warehouse.service.InventoryService;
import org.anyware.anyamall.warehouse.vo.InventoryItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Inventory Management")
@RestController
@RequestMapping("/inventory")
@Slf4j
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @ApiOperation("Inventory List API")
    @GetMapping("/")
    public Inventory getInventory() {
        return inventoryService.findAll();
    }

    @GetMapping("/{id}")
    public InventoryItem getInventoryItem(@PathVariable("id") Long id) {
        return inventoryService.findByArticleId(id);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public InventoryItem update(@PathVariable("id") Long id, @RequestParam Integer stock) {
        log.info("Update inventory {} with {}", id, stock);
        InventoryItem item = inventoryService.findByArticleId(id);
        inventoryService.updateInventoryItem(item, stock);
        return item;
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryItem createInventoryItemWithBindingResult(@Valid InventoryItemRequest inventoryItemRequest) {
        log.info("Receive new InventoryItem {}", inventoryItemRequest);
        InventoryItem inventoryItem = InventoryItem.builder().name(inventoryItemRequest.getName())
                .articleId(inventoryItemRequest.getArtId())
                .stock(inventoryItemRequest.getStock())
                .build();
        return inventoryService.createInventoryItem(inventoryItem);
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryItem createInventoryItemWithoutBindingResult(@Valid @RequestBody InventoryItemRequest inventoryItemRequest) {
        log.info("Receive new InventoryItem {}", inventoryItemRequest);
        InventoryItem inventoryItem = InventoryItem.builder().name(inventoryItemRequest.getName())
                .articleId(inventoryItemRequest.getArtId())
                .stock(inventoryItemRequest.getStock())
                .build();
        return inventoryService.createInventoryItem(inventoryItem);
    }

    @DeleteMapping("/{id}")
    public void deleteInventoryItem(@PathVariable("id") Long id) {
        log.info("Delete an InventoryItem: {}", id);
        InventoryItem item = inventoryService.findByArticleId(id);
        inventoryService.deleteInventoryItem(item);
    }

}
