package com.example.product_management.repository;

import com.example.product_management.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> list = new ArrayList<>();

    static {
        list.add(new Product(1, "tivi", 10));
        list.add(new Product(2, "tủ lạnh", 12));
        list.add(new Product(3, "máy giặt", 15));
        list.add(new Product(4, "điện thoại", 20));
        list.add(new Product(5, "máy tính", 30));
        list.add(new Product(6, "laptop", 10));
        list.add(new Product(7, "điều hòa", 8));
    }

    @Override
    public List<Product> showList() {
        return list;
    }

    @Override
    public void add(Product product) {
        list.add(product);
    }

    @Override
    public void edit(Product product) {
        for (Product p : list) {
            if (p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (Product p : list) {
            if (p.getId() == id) {
                list.remove(p);
                return;
            }
        }
    }

    @Override
    public List<Product> findProduct(String name) {
        List<Product> list1 = new ArrayList<>();
        for (Product p : list) {
            if (p.getName().equals(name)) {
                list1.add(p);
            }
        }
        return list1;
    }

    @Override
    public Product findById(int id) {
        for (Product p : list) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
