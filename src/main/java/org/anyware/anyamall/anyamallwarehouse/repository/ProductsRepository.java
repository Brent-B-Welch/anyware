package org.anyware.anyamall.anyamallwarehouse.repository;

import org.anyware.anyamall.anyamallwarehouse.model.Product;
import org.anyware.anyamall.anyamallwarehouse.model.Products;

import java.util.List;

public interface ProductsRepository {
    Products getAll();

    List<Product> getAll(String name);
}
