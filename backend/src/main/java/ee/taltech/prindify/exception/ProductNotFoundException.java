package ee.taltech.prindify.exception;

public class ProductNotFoundException extends IllegalArgumentException {

    public ProductNotFoundException(int id) {
        super(String.format("Product with ID: %d couldn't be found!", id));
    }
}
