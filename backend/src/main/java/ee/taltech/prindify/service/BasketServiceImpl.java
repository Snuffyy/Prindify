package ee.taltech.prindify.service;

import ee.taltech.prindify.model.basket.Basket;
import ee.taltech.prindify.model.basket.Item;
import java.util.HashSet;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class BasketServiceImpl implements BasketService {

    @Override
    public Basket initBasket(HttpSession session) {

        Basket basket = new Basket(new HashSet<>());
        session.setAttribute(Basket.class.getSimpleName(), basket);

        return basket;
    }

    @Override
    public Basket findBasket(HttpSession session) {
        Object basket = session.getAttribute(Basket.class.getSimpleName());

        if (basket == null) {
            return initBasket(session);
        }

        return (Basket) basket;
    }

    @Override
    public Basket addItem(Basket basket, Item item) {
        basket.getItems().add(item);

        return basket;
    }

    @Override
    public Basket setCount(Basket basket, Item item, int count) {
        removeItem(basket, item);

        if (count < 1) {
            return basket;
        }

        item.setCount(count);
        basket.getItems().add(item);

        return basket;
    }

    @Override
    public Basket removeItem(Basket basket, Item item) {
        basket.getItems().remove(item);

        return basket;
    }

    @Override
    public void clear(Basket basket) {
        basket.getItems().clear();
    }


}
