package ee.taltech.prindify.repository.cutlery;

import ee.taltech.prindify.model.cutlery.Cutlery;
import ee.taltech.prindify.repository.ProductRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CutleryRepository<ObjectThat extends Cutlery> extends
    ProductRepository<ObjectThat> {

}
