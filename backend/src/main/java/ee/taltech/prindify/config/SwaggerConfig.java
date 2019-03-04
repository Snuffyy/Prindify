package ee.taltech.prindify.config;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .ignoredParameterTypes(HttpSession.class)
            .apiInfo(
                new ApiInfo(
                    "Prindify Application",
                    "Merchandise shop with possibility of ordering your own prints to be done on T-shirts.",
                    "alpha",
                    "",
                    new Contact("Maksym Maliarov", "", ""),
                    "",
                    "",
                    new ArrayList<>()
                )
            )
            .select()
            .apis(RequestHandlerSelectors.basePackage("ee.taltech.prindify"))
            .build();

    }
}
