package com.chair.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chair.model.Customer;
import com.chair.service.CartService;
import com.chair.service.CustomerOrderService;

@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") String cartId) {

        CustomerOrder customerOrder = new CustomerOrder();

        Cart cart = cartService.getCartByCartId(cartId);
        // update CartId for customerorder - set cartId
        customerOrder.setCart(cart);

        Customer customer = cart.getCustomer();

        customerOrder.setCustomer(customer);
        // set customer id
        // set ShippingAddressId
        customerOrder.setShippingAddress(customer.getShippingAddress());

        customerOrder.setBillingAddress(customer.getBillingAddress());

        customerOrderService.addCustomerOrder(customerOrder);

        return "redirect:/checkout?cartId=" + cartId;

    }

}