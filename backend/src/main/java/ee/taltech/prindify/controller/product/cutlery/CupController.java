package ee.taltech.prindify.controller.product.cutlery;

import ee.taltech.prindify.exception.ItemValidationException;
import ee.taltech.prindify.model.cutlery.Cup;
import ee.taltech.prindify.repository.cutlery.CupRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Cup", consumes = "application/json", produces = "application/json")
@RestController
public class CupController {

    private final CupRepository repository;

    @Autowired
    public CupController(CupRepository repository) {
        this.repository = repository;
    }

    @ApiOperation(value = "Add Cup")
    @PostMapping("/cups")
    Cup saveCup(@RequestBody Cup cup) {
        return repository.save(cup);
    }

    @ApiOperation(value = "Get Cup by id")
    @GetMapping("/cups/{id}")
    Cup findCupById(@PathVariable int id) {
        return repository.findById(id).orElseThrow(() -> new ItemValidationException(id));
    }

    @ApiOperation(value = "Get all Cups")
    @GetMapping("/cups")
    List<Cup> findAllCups() {
        return repository.findAll();
    }

    @ApiOperation(value = "Delete Cup by id")
    @DeleteMapping("/cups/{id}")
    void deleteCupById(@PathVariable int id) {
        repository.deleteById(id);
    }

    @ApiOperation(value = "Delete all Cups")
    @DeleteMapping("/cups")
    void deleteAllCups() {
        repository.deleteAll();
    }
}
