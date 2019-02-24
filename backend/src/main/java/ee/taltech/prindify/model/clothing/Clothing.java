package ee.taltech.prindify.model.clothing;

import ee.taltech.prindify.model.Product;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Entity
public abstract class Clothing extends Product {

    @Getter
    @Setter
    private Material material;

    enum Material {
        COTTON, LEATHER, SILK
    }
}
