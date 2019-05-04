package ee.taltech.prindify;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import ee.taltech.prindify.dto.query.ItemQueryObject;
import ee.taltech.prindify.model.Product;
import ee.taltech.prindify.model.clothing.TShirt;
import ee.taltech.prindify.service.product.ProductService;
import ee.taltech.prindify.service.query.ItemRequestQueryService;
import ee.taltech.prindify.service.query.ItemRequestQueryServiceImpl;
import java.io.IOException;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ItemQueryTests {

    @MockBean
    private ProductService<Product> productService;

    private ItemRequestQueryService itemRequestQueryService;

    private String productJson = "{\n"
        + "\t\"name\": \"Nike Air\",\n"
        + "\t\"description\": \"Coolest T-Shirt ever designed\",\n"
        + "\t\"image_url\": \"https://google.com\",\n"
        + "\t\"size\": \"S\",\n"
        + "\t\"material\": \"COTTON\",\n"
        + "\t\"price\": 9.99\n"
        + "}";

    private String itemQueryJson = "{\n"
        + "    \"product\": {\n"
        + "        \"id\": 1\n"
        + "    },\n"
        + "    \"count\": 2\n"
        + "}";

    private ObjectMapper oM = new ObjectMapper();

    @Before
    public void setUp() {
        itemRequestQueryService = new ItemRequestQueryServiceImpl(productService);
    }

    @Test
    public void convert() throws IOException {
        Product tShirt = oM.readValue(productJson, TShirt.class);

        Mockito
            .when(productService.findById(1))
            .thenReturn(
                Optional.of(tShirt)
            );

        ItemQueryObject itemQueryObject = oM.readValue(itemQueryJson, ItemQueryObject.class);

        assertThat(itemRequestQueryService.convert(itemQueryObject))
            .matches(item -> item.getCount() == itemQueryObject.getCount())
            .matches(item -> item.getProduct().equals(tShirt));


    }
}
