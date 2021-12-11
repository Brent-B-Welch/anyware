package org.anyware.anyamall.warehouse.repository;

import org.anyware.anyamall.warehouse.model.Product;
import org.anyware.anyamall.warehouse.model.Products;

import java.util.List;

public interface ProductsRepository {
    Products getAll();

    List<Product> getAll(String name);
}
