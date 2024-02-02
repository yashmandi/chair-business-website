package com.chair.dao;

import java.io.IOException;

import com.chair.model.Cart;

public interface CartDAO {

    Cart getCartByCartId(String CartId);

    Cart validateCart(String cartId) throws IOException;

    void updateCart(Cart cart);
}
