package ee.taltech.prindify.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.SessionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    private final
    SessionRepository repository;

    @Autowired
    public SessionController(SessionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/session")
    String getSessionId(HttpSession session) {
        return session.getId();
    }
}
