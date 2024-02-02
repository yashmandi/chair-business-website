package com.chair.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.chair.dao.CartDAO;
import com.chair.model.Cart;
import com.chair.service.CartService;
import com.chair.service.CustomerService;

@Service
public class CartItemController implements CartService {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public CartService getCartService() {
        return cartService;
    }

    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    public CartItemService getCartItemService() {
        return cartItemService;
    }

    @RequestMapping("/cart/add/{productId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addCartItem(@PathVariable(value="productId") String productId) {

}
