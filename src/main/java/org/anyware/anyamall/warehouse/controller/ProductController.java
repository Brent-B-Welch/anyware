package org.anyware.anyamall.warehouse.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.anyware.anyamall.warehouse.model.Product;
import org.anyware.anyamall.warehouse.model.Products;
import org.anyware.anyamall.warehouse.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Product Management")
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
    @Autowired
    private ProductsService productsService;

    @ApiOperation("Product List")
    @GetMapping(value = "/", params = "!name")
    public Products getProducts() {
        Products products = productsService.finaALl();
        return products;
    }

    @ApiOperation("Product List by Name")
    @GetMapping(value = "/", params = "name")
    public List<Product> getProductsByName(@RequestParam String name) {
        List<Product> products = productsService.finaALl(name);
        return products;
    }
}
