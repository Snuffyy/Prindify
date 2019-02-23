package ee.taltech.prindify.controller;

import ee.taltech.prindify.exception.ProductNotFoundException;
import ee.taltech.prindify.model.Product;
import ee.taltech.prindify.model.basket.Basket;
import ee.taltech.prindify.model.basket.Item;
import ee.taltech.prindify.service.BasketService;
import ee.taltech.prindify.service.ProductService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/baskets")
    public Basket findBasketBySession(HttpSession session) {
        return basketService.findBasket(session);
    }

    @PostMapping("/baskets/item")
    public Basket addItemToBasket(@RequestBody Item item, HttpSession session) {
        Basket basket = basketService.findBasket(session);

        Product product = validateProduct(item);
        item.setProduct(product);

        return basketService.addItem(basket, item);
    }

    @DeleteMapping("/baskets")
    public Basket clearBasket(HttpSession session){
        Basket basket = basketService.findBasket(session);
        basketService.clear(basket);

        return basket;
    }

    private Product validateProduct(Item item) {
        int id = item.getProduct().getId();
        return productService.findById(id)
            .orElseThrow(() -> new ProductNotFoundException(id));
    }
}

