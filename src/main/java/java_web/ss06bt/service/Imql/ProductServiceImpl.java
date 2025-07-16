package java_web.ss06bt.service.Imql;

import java_web.ss06bt.entity.Product;
import java_web.ss06bt.entity.ProductPagination;
import java_web.ss06bt.repository.ProductRepository;
import java_web.ss06bt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductPagination getAllProducts(Pageable pageable, String searchName) {
        Page<Product> productPage;
        if (searchName == null || searchName.trim().isEmpty()) {
            productPage = productRepository.findAll(pageable);
        } else {
            productPage = productRepository.findByNameContaining(searchName, pageable);
        }

        return new ProductPagination(
                productPage.getContent(),
                productPage.getTotalPages(),
                productPage.getSize(),
                productPage.getNumber()
        );
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setDescription(productDetails.getDescription());
        product.setStock(productDetails.getStock());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
        productRepository.delete(product);
    }
}