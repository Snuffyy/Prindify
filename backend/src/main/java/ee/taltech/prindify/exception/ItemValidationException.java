package ee.taltech.prindify.exception;

import ee.taltech.prindify.model.basket.Item;

public class ItemValidationException extends IllegalArgumentException {

    public ItemValidationException(Item item) {
        super(String.format("Item : %s couldn't be validated!", item.toString()));
    }
}
