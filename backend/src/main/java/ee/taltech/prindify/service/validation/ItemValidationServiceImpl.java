package ee.taltech.prindify.service.validation;

import ee.taltech.prindify.model.basket.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemValidationServiceImpl implements ItemValidationService {

    @Override
    public boolean validate(Item item) {
        return true;
    }
}
