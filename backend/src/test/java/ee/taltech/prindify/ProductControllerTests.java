package ee.taltech.prindify;

import ee.taltech.prindify.controller.product.ProductController;
import ee.taltech.prindify.model.Product;
import ee.taltech.prindify.model.clothing.Sweater;
import ee.taltech.prindify.model.clothing.Top.Size;
import ee.taltech.prindify.model.cutlery.Cup;
import ee.taltech.prindify.repository.ProductRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class)
public class ProductControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ProductRepository<Product> productRepository;

    private String mockResponse = "[\n"
        + "    {\n"
        + "        \"id\": 2,\n"
        + "        \"name\": \"Nike Air Max\",\n"
        + "        \"description\": \"Coolest Sweater ever designed\",\n"
        + "        \"price\": 29.99,\n"
        + "        \"size\": \"S\",\n"
        + "        \"type\": \"SWEATER\",\n"
        + "        \"image_url\": \"https://google.com\"\n"
        + "    },\n"
        + "    {\n"
        + "        \"id\": 1,\n"
        + "        \"name\": \"Some Cup\",\n"
        + "        \"description\": \"Coolest Cup ever designed\",\n"
        + "        \"price\": 5.99,\n"
        + "        \"type\": \"CUP\",\n"
        + "        \"image_url\": \"https://google.com\"\n"
        + "    }\n"
        + "]";

    @Test
    public void findAllProducts() throws Exception {

        Mockito
            .when(productRepository.findAll())
            .thenReturn(getAllProducts());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
            "/products"
        )
            .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
            .perform(requestBuilder)
            .andReturn();

        JSONAssert.assertEquals(mockResponse, result.getResponse().getContentAsString(), false);
    }

    private List<Product> getAllProducts() {
        Cup mockProduct1 = new Cup();
        mockProduct1.setId(1);
        mockProduct1.setName("Some Cup");
        mockProduct1.setDescription("Coolest Cup ever designed");
        mockProduct1.setPrice(5.99f);
        mockProduct1.setImageUrl("https://google.com");

        Sweater mockProduct2 = new Sweater();
        mockProduct2.setName("Nike Air Max");
        mockProduct2.setId(2);
        mockProduct2.setDescription("Coolest Sweater ever designed");
        mockProduct2.setPrice(29.99f);
        mockProduct2.setSize(Size.S);
        mockProduct2.setImageUrl("https://google.com");

        return Arrays.asList(mockProduct1, mockProduct2);
    }
}
