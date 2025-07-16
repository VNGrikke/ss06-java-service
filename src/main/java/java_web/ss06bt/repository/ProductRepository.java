package java_web.ss06bt.repository;

import java_web.ss06bt.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.name LIKE %:searchName%")
    Page<Product> findByNameContaining(String searchName, Pageable pageable);
}