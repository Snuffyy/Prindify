package ee.taltech.prindify.service;

import ee.taltech.prindify.model.Product;
import ee.taltech.prindify.repository.ProductRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService<Product> {

    @Autowired
    private final ProductRepository<Product> productRepository;

    public ProductServiceImpl(
        ProductRepository<Product> productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }
}
