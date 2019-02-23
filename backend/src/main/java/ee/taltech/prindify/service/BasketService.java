package ee.taltech.prindify.service;

import ee.taltech.prindify.model.basket.Basket;
import ee.taltech.prindify.model.basket.Item;
import javax.servlet.http.HttpSession;

public interface BasketService {

    Basket initBasket(HttpSession session);

    Basket findBasket(HttpSession session);

    Basket addItem(Basket basket, Item item);

    Basket setCount(Basket basket, Item item, int count);

    Basket removeItem(Basket basket, Item item);

    void clear(Basket basket);
}
