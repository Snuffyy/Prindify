package ee.taltech.prindify.controller.product.cutlery;

import ee.taltech.prindify.exception.ProductNotFoundException;
import ee.taltech.prindify.model.cutlery.Cup;
import ee.taltech.prindify.repository.cutlery.CupRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CupController {

    private final CupRepository repository;

    @Autowired
    public CupController(CupRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/cups")
    Cup saveCup(@RequestBody Cup cup) {
        return repository.save(cup);
    }

    @GetMapping("/cups/{id}")
    Cup findCupById(@PathVariable int id) {
        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @GetMapping("/cups")
    List<Cup> findAllCups() {
        return repository.findAll();
    }
}
