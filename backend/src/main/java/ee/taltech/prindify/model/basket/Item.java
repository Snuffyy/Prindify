package ee.taltech.prindify.model.basket;

import ee.taltech.prindify.model.Product;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private String id;
    private Product product;
    private int count;

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
