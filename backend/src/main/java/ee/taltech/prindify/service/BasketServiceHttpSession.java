package ee.taltech.prindify.service;

import ee.taltech.prindify.model.basket.Basket;
import ee.taltech.prindify.model.basket.Item;
import ee.taltech.prindify.repository.basket.BasketRepository;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketServiceHttpSession implements BasketService<HttpSession> {

    private final BasketRepository<HttpSession> basketRepository;

    private final ItemValidationService itemValidationService;

    @Autowired
    public BasketServiceHttpSession(BasketRepository<HttpSession> basketRepository,
        ItemValidationService itemValidationService) {
        this.basketRepository = basketRepository;
        this.itemValidationService = itemValidationService;
    }

    @Override
    public Optional<Basket> findBasket(HttpSession session) {
        return basketRepository.findBasket(session);
    }

    @Override
    public Basket createBasket(HttpSession session) {
        return basketRepository.createBasket(session);
    }

    @Override
    public Basket updateBasket(Basket old, Basket basket) {
        return basketRepository.updateBasket(old, basket);
    }


    @Override
    public Basket addItem(Basket basket, Item item) {
        basket.getItems().add(item);

        return basket;
    }

    @Override
    public Basket updateItem(Basket basket, String id, Item item) {

        if (!itemValidationService.validate(item)) {
            return basket;
        }

        Optional<Item> toUpdate = basket.getItems().stream().filter((i) -> i.getId().equals(id))
            .findFirst();

        toUpdate.ifPresent((i) -> {
            i.setCount(item.getCount());
            i.setProduct(item.getProduct());
        });

        return basket;
    }


    @Override
    public Basket removeItem(Basket basket, String id) {

        Optional<Item> toRemove = basket.getItems().stream().filter((i) -> i.getId().equals(id))
            .findFirst();

        toRemove.ifPresent((item -> basket.getItems().remove(item)));

        return basket;
    }

    @Override
    public void clear(Basket basket) {
        basketRepository.clear(basket);
    }
}
