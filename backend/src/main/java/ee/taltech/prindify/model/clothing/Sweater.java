package ee.taltech.prindify.model.clothing;

import ee.taltech.prindify.model.Type;
import javax.persistence.Entity;

@Entity
public class Sweater extends Top {

    @Override
    public Type getType() {
        return Type.SWEATER;
    }
}
