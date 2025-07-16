package java_web.ss06bt.controller;

import java_web.ss06bt.entity.ProductCart;
import java_web.ss06bt.entity.User;
import java_web.ss06bt.service.ProductCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class ProductCartController {

    @Autowired
    private ProductCartService productCartService;

    @GetMapping
    public ResponseEntity<List<ProductCart>> getCartItems(@RequestParam Long userId) {
        User user = new User();
        user.setId(userId); // Trong thực tế, nên lấy User từ cơ sở dữ liệu hoặc thông qua xác thực
        List<ProductCart> cartItems = productCartService.getCartItemsByUser(user);
        return ResponseEntity.ok(cartItems);
    }

    @PostMapping
    public ResponseEntity<ProductCart> addToCart(@RequestBody ProductCart productCart) {
        ProductCart createdCartItem = productCartService.addToCart(productCart);
        return ResponseEntity.status(201).body(createdCartItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCart> updateQuantity(@PathVariable Long id, @RequestBody Integer quantity) {
        ProductCart updatedCartItem = productCartService.updateQuantity(id, quantity);
        return ResponseEntity.ok(updatedCartItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long id) {
        productCartService.removeFromCart(id);
        return ResponseEntity.noContent().build();
    }
}
