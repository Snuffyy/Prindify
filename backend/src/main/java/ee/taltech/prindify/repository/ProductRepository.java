package ee.taltech.prindify.repository;

import ee.taltech.prindify.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository<T extends Product> extends
    JpaRepository<T, Integer> {


}


