package ee.taltech.prindify.repository.clothing;

import ee.taltech.prindify.model.clothing.Sweater;
import org.springframework.stereotype.Repository;

@Repository
public interface SweaterRepository extends
    TopsRepository<Sweater> {

}