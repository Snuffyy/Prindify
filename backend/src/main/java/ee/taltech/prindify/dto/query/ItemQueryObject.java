package ee.taltech.prindify.dto.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ItemQueryObject extends QueryObject {

    @JsonProperty("product")
    private ProductQueryObject productQueryObject;
    private int count;

}
