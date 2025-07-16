package java_web.ss06bt.service;


import java_web.ss06bt.entity.ProductCart;
import java_web.ss06bt.entity.User;

import java.util.List;

public interface ProductCartService {
    List<ProductCart> getCartItemsByUser(User user);
    ProductCart addToCart(ProductCart productCart);
    ProductCart updateQuantity(Long id, Integer quantity);
    void removeFromCart(Long id);
}