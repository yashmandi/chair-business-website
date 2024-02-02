package com.chair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chair.dao.CustomerOrderDAO;
import com.chair.model.Cart;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDAO customerOrderDAO;

    @Autowired
    private CartService cartService;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDAO.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderGrandTotal(String cartId) {
        double grandTotal = 0;
        Cart cart = cartService.getCartByCartId(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItems item : cartItems) {
            grandTotal += item.getPrice();
        }
        return grandTotal;

    }

}
