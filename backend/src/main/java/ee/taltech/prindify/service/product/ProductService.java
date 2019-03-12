package ee.taltech.prindify.service.product;

import ee.taltech.prindify.model.Product;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface ProductService<T extends Product> {

    Optional<T> findById(int id);
}
