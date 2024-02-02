package com.chair.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.JpaSort.Path;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.chair.model.Product;

import jakarta.annotation.PreDestroy;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonMultipartResolver();
        multipartResolver.setMaxUploadSize(10240000);
        return multipartResolver();
    }

    // Request Mapping

    // which displays the list of products to the productList page

    /*
     * Product List using Angular
     * 
     * @RequestMapping("/getAllProducts")
     * public ModelAndView getAllProducts() {
     * List<Product> products = productService.getAllProducts();
     * return new ModelAndView("productListAngular", "products", products);
     * }
     */
    // Normal ProductList view

    @RequestMapping("/getAllProducts")
    public ModelAndView getAllProducts() {
        List<Product> product = productService.getAllProducts();
        return new ModelAndView("productList", "products", product);
    }

    // this is used to get product by product id
    @RequestMapping("getProductById/{productId}")
    public ModelAndView getProductById(@PathVariable(value = "productId") String productId) {
        Product product = productService.getProductById(productId);
        return new ModelAndView("productPage", "product", product);
    }

    @RequestMapping("/admin/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable(value = "productId") String productId) {

        // here, the path class is used to refer the path of the file

        Path path = Paths.get("src/main/resources/static/productImages/" + productId + ".png");

        if (Files.exists(path)) {
            try {
                Files.delete(null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        productService.deleteProduct(productId);
        // http://localhost:8080/shoppingCart/getAllProducts
        return "redirect:/getAllProducts";
    }

    @RequestMapping(value = "/admin/product/addProduct", method = RequestMethod.GET)
    public String getProductsFrom(Model model) {
        Product product = new Product();
        // New Arrivals
        // Set the category as 1 for Chair chair
        product.setProductCategory("Accessories");
        model.addAttribute("productFormObj", product);
        return "addProduct";
    }

    @RequestMapping(value = "/admin/product/addProduct", method = RequestMethod.POST)
    public String addProduct (@Valid @ModelAttribute (value = "productFormObj") Product product, BindingResult result) {
        // binding result is used if the form that has any error then 
        // it will redirect to same page without performing any functions
        if (result.hasErrors())
            return "addProduct";
        productService.addProduct(product);
        MultipartFile image = product.getProductImage();
        if (image != null && !image.isEmpty()) {
            Path path = Paths.get("src/main/resources/static/productImages/" + product.getProductId() + ".png");
        
            try {
                image.transferTo(new File(path.toString()));
            } catch (IllegalStateException) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/getAllProducts";
}

    @RequestMapping(value = "/admin/product/getEditForm/{productId}")
    public ModelAndView getEditForm(@PathVariable(value = "productId") String productId) {
        Product product = productService.getProductById(productId);
        return new ModelAndView("updateProduct", "productFormObj", product);
    }

    @RequestMapping(value = "/admin/product/editProduct", method = RequestMethod.POST)
    public String editProduct(@ModelAttribute(value = "editProductObj") Product product) {
        productService.updateProduct(product);
        return "redirect:/getAllProducts";
    }

    @RequestMapping("/getProductList")
    public @ResponseBody List<Product> getProductsListInJson() {
        return productService.getAllProducts();
    }

    @RequestMapping("/productsListAngular")
    public String getProducts() {
        return "productListAngular"; 
    }

}
