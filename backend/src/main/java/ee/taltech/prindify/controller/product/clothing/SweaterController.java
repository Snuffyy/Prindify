package ee.taltech.prindify.controller.product.clothing;

import ee.taltech.prindify.exception.ItemValidationException;
import ee.taltech.prindify.model.clothing.Sweater;
import ee.taltech.prindify.repository.clothing.SweaterRepository;
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

@Api(value = "Sweater", consumes = "application/json", produces = "application/json")
@RestController
public class SweaterController {

    private final SweaterRepository repository;

    @Autowired
    public SweaterController(SweaterRepository repository) {
        this.repository = repository;
    }

    @ApiOperation(value = "Add Sweater")
    @PostMapping("/sweaters")
    Sweater saveSweater(@RequestBody Sweater sweater) {
        return repository.save(sweater);
    }

    @ApiOperation(value = "Get Sweater by id")
    @GetMapping("/sweaters/{id}")
    Sweater findSweaterById(@PathVariable int id) {
        return repository.findById(id).orElseThrow(() -> new ItemValidationException(id));
    }

    @ApiOperation(value = "Get all Sweaters")
    @GetMapping("/sweaters")
    List<Sweater> findAllSweaters() {
        return repository.findAll();
    }

    @ApiOperation(value = "Delete Sweater by id")
    @DeleteMapping("/sweaters/{id}")
    void deleteSweaterById(@PathVariable int id) {
        repository.deleteById(id);
    }

    @ApiOperation(value = "Delete all Sweaters")
    @DeleteMapping("/sweaters")
    void deleteAllSweaters() {
        repository.deleteAll();
    }
}
