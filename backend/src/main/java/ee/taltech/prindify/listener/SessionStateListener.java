package ee.taltech.prindify.listener;

import ee.taltech.prindify.service.BasketService;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionStateListener implements HttpSessionListener {

    private final BasketService<HttpSession> basketService;

    @Autowired
    public SessionStateListener(BasketService<HttpSession> basketService) {
        this.basketService = basketService;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        basketService.createBasket(se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
