package com.example.product_management.repository;

import com.example.product_management.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> showList();

    void add(Product product);

    void edit(Product product);

    void delete(int id);

    List<Product> findProduct(String name);

    Product findById(int id);
}
