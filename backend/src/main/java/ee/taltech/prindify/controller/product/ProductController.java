package ee.taltech.prindify.controller.product;

import ee.taltech.prindify.model.Product;
import ee.taltech.prindify.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Product", consumes = "application/json", produces = "application/json")
@RestController
public class ProductController {

    private final
    ProductRepository<Product> productRepository;

    @Autowired
    public ProductController(ProductRepository<Product> productRepository) {
        this.productRepository = productRepository;
    }

    @ApiOperation(value = "Get all Products")
    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @ApiOperation(value = "Delete all Products")
    @DeleteMapping("/products")
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }
}
