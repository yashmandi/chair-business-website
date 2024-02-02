package com.chair.model;

import java.io.Serializable;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "item")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productId;

    @Column(name = "category")
    private String productCategory;

    @Column(name = "description")
    private String productDescription;

    @Column(name = "manufacturer")
    private String productManufacturer;

    @NotEmpty(message = "Product name is mandatory")
    @Column(name = "name")
    private String productName;

    @NotNull
    @Min(value = 100, message = "Price cannot be less than 100")
    @Column(name = "price")
    private double productPrice;

    @Column(name = "unit")
    private MultipartFile unitStock;

    @Transient
    private MultipartFile unitStock;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getUnitStock() {
        return unitStock;
    }

    public void setUnitStock(MultipartFile unitStock) {
        this.unitStock = unitStock;
    }

    public MultipartFile getUnitStock() {
        return unitStock;
    }

    public void setUnitStock(MultipartFile unitStock) {
        this.unitStock = unitStock;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productCategory=" + productCategory + ", productDescription="
                + productDescription + ", productManufacturer=" + productManufacturer + ", productName=" + productName
                + ", productPrice=" + productPrice + ", unitStock=" + unitStock + "]";
    }

    public Product() {

    }

}
