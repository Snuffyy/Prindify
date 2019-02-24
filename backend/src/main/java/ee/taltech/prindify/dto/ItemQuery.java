package ee.taltech.prindify.dto;

import ee.taltech.prindify.model.basket.Item;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ItemQuery extends ObjectQuery<Item> {

    private ProductQuery product;
    private int count;
}
