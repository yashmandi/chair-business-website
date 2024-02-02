package com.chair.dao;

import java.util.List;

import com.chair.model.Product;

public interface ProductDAO {

    public List<Product> getAllProducts();

    public Product getProductById(String productId);

    public void deleteProduct(String productId);

    public void addProduct(Product product);

    public void editProduct(Product product);

}
