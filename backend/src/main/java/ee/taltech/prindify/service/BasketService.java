package ee.taltech.prindify.service;

import ee.taltech.prindify.model.basket.Basket;
import ee.taltech.prindify.model.basket.Item;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface BasketService<T> {

    Optional<Basket> findBasket(T discriminator);

    Basket createBasket(T discriminator);

    Basket updateBasket(Basket old, Basket basket);

    Basket addItem(Basket basket, Item item);

    Basket updateItem(Basket basket, String id, Item item);

    Basket removeItem(Basket basket, String id);

    void clear(Basket basket);
}
