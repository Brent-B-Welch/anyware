package org.anyware.anyamall.anyamallwarehouse.controller;

import lombok.extern.slf4j.Slf4j;
import org.anyware.anyamall.anyamallwarehouse.model.Product;
import org.anyware.anyamall.anyamallwarehouse.model.Products;
import org.anyware.anyamall.anyamallwarehouse.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
    @Autowired
    private ProductsService productsService;

    @GetMapping(value = "/", params = "!name")
    public Products getProducts() {
        Products products = productsService.finaALl();
        return products;
    }

    @GetMapping(value = "/", params = "name")
    public List<Product> getProductsByName(@RequestParam String name) {
        List<Product> products = productsService.finaALl(name);
        return products;
    }
}
