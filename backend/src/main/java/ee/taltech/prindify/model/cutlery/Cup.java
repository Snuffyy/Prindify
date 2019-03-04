package ee.taltech.prindify.model.cutlery;

import ee.taltech.prindify.model.Type;
import javax.persistence.Entity;

@Entity
public class Cup extends Cutlery {

    @Override
    public Type getType() {
        return Type.CUP;
    }
}
