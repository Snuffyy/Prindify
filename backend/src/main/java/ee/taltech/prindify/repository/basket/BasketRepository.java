package ee.taltech.prindify.repository.basket;

import ee.taltech.prindify.model.basket.Basket;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository<T> {

    Basket createBasket(T discriminator);

    Optional<Basket> findBasket(T discriminator);

    Basket updateBasket(Basket old, Basket basket);

    void clear(Basket basket);
}
