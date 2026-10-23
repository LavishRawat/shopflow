package com.shopflow;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

public class ProductCatalog {

    private List<Product> products = new ArrayList<>();
    private int nextId = 1;

    public void addProduct(String name, BigDecimal price, int stock) {
        Product product = new Product(nextId, name, price, stock);
        products.add(product);
        nextId ++;
    }

    public List<Product> getAllProducts() {
        return products;
    }

}
