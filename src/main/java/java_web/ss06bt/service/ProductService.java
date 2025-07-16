package java_web.ss06bt.service;

import java_web.ss06bt.entity.Product;
import java_web.ss06bt.entity.ProductPagination;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    ProductPagination getAllProducts(Pageable pageable, String searchName);
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}