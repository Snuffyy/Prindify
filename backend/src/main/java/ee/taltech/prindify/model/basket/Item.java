package ee.taltech.prindify.model.basket;

import ee.taltech.prindify.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private Product product;
    private int count;
}
