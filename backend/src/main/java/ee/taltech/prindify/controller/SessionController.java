package ee.taltech.prindify.controller;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @GetMapping("/session")
    String getSessionId(HttpSession session) {
        return session.getId();
    }
}
