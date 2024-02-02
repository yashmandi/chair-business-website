package com.chair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chair.dao.ProductDAO;
import com.chair.model.Product;

import jakarta.transaction.Transactional;

@Service(value = "productService")
public class ProductServiceImpl {

    @Autowired
    private ProductDAO productDAO;

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Transactional
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Transactional
    public Product getProductById(String productId) {
        return productDAO.getProductById(productId);
    }

    @Transactional
    public void deleteProduct(String productId) {
        productDAO.deleteProduct(productId);
    }

    @Transactional
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    @Transactional
    public void editProduct(Product product) {
        productDAO.editProduct(product);
    }

}
