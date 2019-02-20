package ee.taltech.prindify.model.clothing;

import javax.persistence.Entity;

@Entity
public abstract class Tops extends Clothing {

    enum Size {XS, S, M, L, XL, XXL}
}
