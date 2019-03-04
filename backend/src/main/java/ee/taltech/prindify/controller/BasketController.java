package ee.taltech.prindify.controller;

import ee.taltech.prindify.exception.ProductNotFoundException;
import ee.taltech.prindify.model.Product;
import ee.taltech.prindify.model.basket.Basket;
import ee.taltech.prindify.model.basket.Item;
import ee.taltech.prindify.service.BasketService;
import ee.taltech.prindify.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Basket", consumes = "application/json", produces = "application/json")
@RestController
public class BasketController {

    private final BasketService basketService;
    private final ProductService<Product> productService;

    @Autowired
    public BasketController(BasketService basketService,
        ProductService<Product> productService) {
        this.basketService = basketService;
        this.productService = productService;
    }

    @ApiOperation(value = "Get Basket for current session")
    @GetMapping("/baskets")
    public Basket getBasketBySession(HttpSession session) {
        return basketService.findBasket(session);
    }

    @ApiOperation(value = "Add Item to Basket for current session")
    @PostMapping("/baskets/item")
    public Basket addItemToBasket(@RequestBody Item item, HttpSession session) {
        Basket basket = basketService.findBasket(session);

        return basketService.addItem(basket, validateItem(item));
    }

    @ApiOperation(value = "Clear Basket for current session")
    @DeleteMapping("/baskets")
    public Basket clearBasket(HttpSession session) {
        Basket basket = basketService.findBasket(session);
        basketService.clear(basket);

        return basket;
    }

    private Item validateItem(Item item) {
        int id = item.getProduct().getId();

        Product product = productService.findById(id)
            .orElseThrow(() -> new ProductNotFoundException(id));

        return new Item(product, item.getCount());
    }
}

