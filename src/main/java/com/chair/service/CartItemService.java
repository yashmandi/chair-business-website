package com.chair.service;

import com.chair.model.Cart;
import com.chair.model.CartItem;

public interface CartItemService {

    void addCartItem(CartItem cartItem);

    void removeCartItem(String CartItemId);

    void removeAllCartItems(Cart cart);

}
