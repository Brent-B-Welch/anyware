package org.anyware.anyamall.anyamallwarehouse.service;

import org.anyware.anyamall.anyamallwarehouse.model.Product;
import org.anyware.anyamall.anyamallwarehouse.model.Products;

import java.util.List;

public interface ProductsService {
    Products finaALl();

    List<Product> finaALl(String name);
}
