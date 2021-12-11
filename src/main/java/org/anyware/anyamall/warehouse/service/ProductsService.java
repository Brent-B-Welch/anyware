package org.anyware.anyamall.warehouse.service;

import org.anyware.anyamall.warehouse.model.Product;
import org.anyware.anyamall.warehouse.model.Products;

import java.util.List;

public interface ProductsService {
    Products finaALl();

    List<Product> finaALl(String name);
}
