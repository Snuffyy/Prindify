package ee.taltech.prindify.service.product;

import ee.taltech.prindify.model.Product;
import ee.taltech.prindify.repository.ProductRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService<Product> {

    private final ProductRepository<Product> productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository<Product> productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }
}
