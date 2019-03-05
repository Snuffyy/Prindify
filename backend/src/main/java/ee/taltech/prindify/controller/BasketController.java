package ee.taltech.prindify.controller;

import ee.taltech.prindify.exception.ItemValidationException;
import ee.taltech.prindify.exception.ResponseBasketNotFoundException;
import ee.taltech.prindify.model.Product;
import ee.taltech.prindify.model.basket.Basket;
import ee.taltech.prindify.model.basket.Item;
import ee.taltech.prindify.service.BasketService;
import ee.taltech.prindify.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Basket", consumes = "application/json", produces = "application/json")
@RestController
public class BasketController {

    private final BasketService<HttpSession> basketService;
    private final ProductService<Product> productService;

    @Autowired
    public BasketController(BasketService<HttpSession> basketService,
        ProductService<Product> productService) {
        this.basketService = basketService;
        this.productService = productService;
    }

    @ApiOperation(value = "Get Basket for current session")
    @GetMapping("/baskets")
    public Basket getBasketBySession(HttpSession session) {
        return findBasket(session);
    }


    @ApiOperation(value = "Clear Basket for current session")
    @DeleteMapping("/baskets")
    public void clearBasket(HttpSession session) {
        Basket basket = findBasket(session);

        basketService.clear(basket);
    }

    @ApiOperation(value = "Add Item to Basket for current session")
    @PostMapping("/baskets/item")
    public Basket addItemToBasket(@RequestBody Item _item, HttpSession session) {
        Item item = validateItem(_item);
        Basket basket = findBasket(session);

        return basketService.addItem(basket, item);
    }

    @ApiOperation(value = "Update Item in Basket for current session")
    @PutMapping("/baskets/item/{id}")
    public Basket updateItemInBasket(@PathVariable("id") String itemId, @RequestBody Item _item,
        HttpSession session) {

        Basket basket = findBasket(session);
        Item item = validateItem(_item);

        return basketService.updateItem(basket, itemId, item);
    }

    @ApiOperation(value = "Delete Item from Basket for current session")
    @DeleteMapping("/baskets/item/{id}")
    public Basket deleteItemFromBasket(@PathVariable("id") String itemId, HttpSession session) {

        Basket basket = findBasket(session);

        return basketService.removeItem(basket, itemId);
    }

    private Basket findBasket(HttpSession session) {
        return basketService.findBasket(session)
            .orElseThrow(() -> new ResponseBasketNotFoundException(session.getId()));
    }

    private Item validateItem(Item item) {
        int id = item.getProduct().getId();

        Product product = productService.findById(id)
            .orElseThrow(() -> new ItemValidationException(item));

        return new Item(UUID.randomUUID().toString(), product, item.getCount());
    }
}

