package ee.taltech.prindify.repository.clothing;

import ee.taltech.prindify.model.clothing.Clothing;
import ee.taltech.prindify.repository.ProductRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothingRepository<T extends Clothing> extends
    ProductRepository<T> {
}
