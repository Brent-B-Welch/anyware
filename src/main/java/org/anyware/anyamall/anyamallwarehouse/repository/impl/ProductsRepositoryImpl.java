package org.anyware.anyamall.anyamallwarehouse.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.anyware.anyamall.anyamallwarehouse.model.Product;
import org.anyware.anyamall.anyamallwarehouse.model.Products;
import org.anyware.anyamall.anyamallwarehouse.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
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
        return products;
    }

    @Override
    public List<Product> getAll(String name) {
        List<Product> collect = products.getProudcts().stream().filter(product -> product.getName().equals(name)).collect(Collectors.toList());
        return collect;
    }
}
