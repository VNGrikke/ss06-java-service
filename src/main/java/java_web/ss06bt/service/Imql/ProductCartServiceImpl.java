package java_web.ss06bt.service.Imql;

import java_web.ss06bt.entity.ProductCart;
import java_web.ss06bt.entity.User;
import java_web.ss06bt.repository.ProductCartRepository;
import java_web.ss06bt.service.ProductCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCartServiceImpl implements ProductCartService {

    @Autowired
    private ProductCartRepository productCartRepository;

    @Override
    public List<ProductCart> getCartItemsByUser(User user) {
        return productCartRepository.findByUser(user);
    }

    @Override
    public ProductCart addToCart(ProductCart productCart) {
        return productCartRepository.save(productCart);
    }

    @Override
    public ProductCart updateQuantity(Long id, Integer quantity) {
        ProductCart productCart = productCartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart item not found with id " + id));
        productCart.setQuantity(quantity);
        return productCartRepository.save(productCart);
    }

    @Override
    public void removeFromCart(Long id) {
        ProductCart productCart = productCartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart item not found with id " + id));
        productCartRepository.delete(productCart);
    }
}