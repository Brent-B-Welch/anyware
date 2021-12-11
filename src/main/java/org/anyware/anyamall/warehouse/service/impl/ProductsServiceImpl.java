package org.anyware.anyamall.warehouse.service.impl;

import org.anyware.anyamall.warehouse.model.Product;
import org.anyware.anyamall.warehouse.model.Products;
import org.anyware.anyamall.warehouse.repository.ProductsRepository;
import org.anyware.anyamall.warehouse.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productsService")
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public Products finaALl() {
        return productsRepository.getAll();
    }

    @Override
    public List<Product> finaALl(String name) {
        return productsRepository.getAll(name);
    }
}
