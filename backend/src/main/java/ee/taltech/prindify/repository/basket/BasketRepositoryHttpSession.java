package ee.taltech.prindify.repository.basket;

import ee.taltech.prindify.model.basket.Basket;
import java.util.HashSet;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Repository;

@Repository
public class BasketRepositoryHttpSession implements BasketRepository<HttpSession> {

    @Override
    public Basket createBasket(HttpSession session) {
        Basket basket = new Basket(new HashSet<>());
        session.setAttribute(Basket.class.getSimpleName(), basket);

        return basket;
    }

    @Override
    public Optional<Basket> findBasket(HttpSession session) {
        return Optional.ofNullable((Basket) session.getAttribute(Basket.class.getSimpleName()));
    }

    @Override
    public Basket updateBasket(Basket old, Basket basket) {
        old.setItems(basket.getItems());

        return old;
    }

    @Override
    public void clear(Basket basket) {
        basket.getItems().clear();
    }
}
