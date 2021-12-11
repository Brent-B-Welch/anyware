package org.anyware.anyamall.anyamallwarehouse.service.impl;

import org.anyware.anyamall.anyamallwarehouse.model.Product;
import org.anyware.anyamall.anyamallwarehouse.model.Products;
import org.anyware.anyamall.anyamallwarehouse.repository.ProductsRepository;
import org.anyware.anyamall.anyamallwarehouse.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productsService")
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public Products finaALl() {
        Products products = productsRepository.getAll();
        return products;
    }

    @Override
    public List<Product> finaALl(String name) {
        return productsRepository.getAll(name);
    }
}
