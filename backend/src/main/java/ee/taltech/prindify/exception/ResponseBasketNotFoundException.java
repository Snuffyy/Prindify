package ee.taltech.prindify.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ResponseBasketNotFoundException extends ResponseStatusException {

    public ResponseBasketNotFoundException(String session) {
        super(HttpStatus.NOT_FOUND, String.format("Basket for Session: %s couldn't be found!", session));
    }
}
