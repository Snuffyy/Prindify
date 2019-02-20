package ee.taltech.prindify.controller.product;

import ee.taltech.prindify.model.Product;
import ee.taltech.prindify.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final
    ProductRepository<Product> productRepository;

    @Autowired
    public ProductController(ProductRepository<Product> productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
