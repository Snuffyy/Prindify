package ee.taltech.prindify.service.query;

import ee.taltech.prindify.dto.query.ItemQueryObject;
import ee.taltech.prindify.exception.ProductNotFoundException;
import ee.taltech.prindify.model.Product;
import ee.taltech.prindify.model.basket.Item;
import ee.taltech.prindify.service.product.ProductService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemRequestQueryServiceImpl implements ItemRequestQueryService {

    private final ProductService<Product> productService;

    @Autowired
    public ItemRequestQueryServiceImpl(ProductService<Product> productService) {
        this.productService = productService;
    }

    @Override
    public Item convert(ItemQueryObject itemQueryObject) {
        int productId = itemQueryObject.getProductQueryObject().getId();

        Product product = productService.findById(productId)
            .orElseThrow(() -> new ProductNotFoundException(productId));
        int count = itemQueryObject.getCount();

        return new Item(UUID.randomUUID().toString(), product, count);
    }
}
