package ee.taltech.prindify.controller.product.clothing;

import ee.taltech.prindify.exception.ProductNotFoundException;
import ee.taltech.prindify.model.clothing.Sweater;
import ee.taltech.prindify.repository.clothing.SweaterRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SweaterController {

    private final SweaterRepository repository;

    @Autowired
    public SweaterController(SweaterRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/sweaters")
    Sweater saveSweater(@RequestBody Sweater sweater) {
        return repository.save(sweater);
    }

    @GetMapping("/sweaters/{id}")
    Sweater findSweaterById(@PathVariable int id) {
        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @GetMapping("/sweaters")
    List<Sweater> findAllSweaters() {
        return repository.findAll();
    }
}
