package ee.taltech.prindify.repository.clothing;

import ee.taltech.prindify.model.clothing.Top;
import org.springframework.stereotype.Repository;

@Repository
public interface TopsRepository<T extends Top> extends ClothingRepository<T> {
}
