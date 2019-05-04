package ee.taltech.prindify.controller;

import javax.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @GetMapping("session")
    public SessionDTO getSessionId(HttpSession session){
        return new SessionDTO(session.getId());
    }


    @Data
    @AllArgsConstructor
    class SessionDTO {
        private String id;
    }
}
