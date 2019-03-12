package ee.taltech.prindify.dto.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ProductQueryObject extends QueryObject {

    private int id;
}
