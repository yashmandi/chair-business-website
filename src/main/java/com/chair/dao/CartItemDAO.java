package com.chair.dao;

import com.chair.model.Cart;
import com.chair.model.CartItem;

public interface CartItemDAO {

    void addCartItem(CartItem cartItem);

    void removeCartItem(String CartItemId);

    void removeAllCartItems(Cart cart);

}