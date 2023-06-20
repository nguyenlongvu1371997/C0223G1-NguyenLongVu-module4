package com.example.product_management.service;

import com.example.product_management.model.Product;
import com.example.product_management.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> showList() {
        return productRepository.showList();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void edit(Product product) {
        productRepository.edit(product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> findProduct(String name) {
        return productRepository.findProduct(name);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }
}
