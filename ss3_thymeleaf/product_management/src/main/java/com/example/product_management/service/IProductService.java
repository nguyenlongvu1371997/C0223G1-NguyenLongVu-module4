package com.example.product_management.service;

import com.example.product_management.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showList();

    void add(Product product);

    void edit(Product product);

    void delete(int id);

    List<Product> findProduct(String name);

    Product findById(int id);
}
