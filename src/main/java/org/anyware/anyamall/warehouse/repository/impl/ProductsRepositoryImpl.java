package org.anyware.anyamall.warehouse.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.anyware.anyamall.warehouse.model.Product;
import org.anyware.anyamall.warehouse.model.Products;
import org.anyware.anyamall.warehouse.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ProductsRepositoryImpl implements ProductsRepository {
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private Products products;

    @Override
    public Products getAll() {
        return this.products;
    }

    @Override
    public List<Product> getAll(String name) {
        return products.getProudcts().stream().filter(product -> product.getName().equals(name)).collect(Collectors.toList());
    }
}
