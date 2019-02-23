package ee.taltech.prindify.model.clothing;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
public abstract class Tops extends Clothing {

    @Getter
    @Setter
    private Size size;

    enum Size {
        XS, S, M, L, XL, XXL
    }
}
