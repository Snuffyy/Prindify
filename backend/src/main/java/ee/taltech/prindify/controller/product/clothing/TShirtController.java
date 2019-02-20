package ee.taltech.prindify.controller.product.clothing;

import ee.taltech.prindify.model.clothing.TShirt;
import ee.taltech.prindify.repository.clothing.TShirtRepository;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TShirtController {

    private final TShirtRepository repository;

    @Autowired
    public TShirtController(TShirtRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/t-shirts")
    TShirt saveTShirt(@RequestBody TShirt tShirt) {
        return repository.save(tShirt);
    }

    @GetMapping("/t-shirts/{id}")
    TShirt findTShirtById(@PathVariable int id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @GetMapping("/t-shirts")
    List<TShirt> findAllTShirts(HttpSession session) {
        return repository.findAll();
    }
}
