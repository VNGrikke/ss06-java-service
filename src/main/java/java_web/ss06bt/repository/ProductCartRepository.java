package java_web.ss06bt.repository;

import java_web.ss06bt.entity.ProductCart;
import java_web.ss06bt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCartRepository extends JpaRepository<ProductCart, Long> {
    List<ProductCart> findByUser(User user);
}