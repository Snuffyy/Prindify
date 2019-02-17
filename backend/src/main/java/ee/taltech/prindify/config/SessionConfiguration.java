package ee.taltech.prindify.config;

import java.util.HashMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

@Configuration
@EnableSpringHttpSession
public class SessionConfiguration {

    @Bean
    MapSessionRepository sessionRepository(){
        return new MapSessionRepository(new HashMap<>());
    }

}
