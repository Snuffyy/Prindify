package ee.taltech.prindify.service;

import ee.taltech.prindify.model.Product;
import java.util.Optional;

public interface ProductService<T extends Product> {

    Optional<T> findById(int id);
}
