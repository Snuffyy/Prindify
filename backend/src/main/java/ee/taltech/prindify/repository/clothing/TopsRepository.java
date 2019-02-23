package ee.taltech.prindify.repository.clothing;

import ee.taltech.prindify.model.clothing.Tops;
import org.springframework.stereotype.Repository;

@Repository
public interface TopsRepository<T extends Tops> extends ClothingRepository<T> {
}
