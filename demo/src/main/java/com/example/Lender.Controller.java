package com.example;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
class LenderController {

    @Autowired
    private LenderRepo lenderRepo;

    public LenderController() {
    }

    @GetMapping("/api/lenders")
    Iterable<Lender> getLenders(@RequestParam Optional<String> lenderType) {
        return lenderRepo.findAll();
    }

    @GetMapping("/api/lenders/{id}")
    Optional<Lender> getLender(@PathVariable long id) {
        return lenderRepo.findById(id);
    }

    @PostMapping("/api/lenders")
    Lender createLender(@RequestBody Lender lender) {
        return lenderRepo.save(lender);
    }

    @PutMapping("/api/lenders/{id}")
    Optional<Lender> updateLender(@RequestBody Lender lenderRequest, @PathVariable long id) {
        Optional<Lender> opt = lenderRepo.findById(id);
        if (opt.isPresent()) {
            if (lenderRequest.getId() == id) {
                return Optional.of(lenderRepo.save(lenderRequest));
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Erro ao alterar dados do lender com id " + id);
    }

    @DeleteMapping(value = "/api/lenders/{id}")
    void deleteLender(@PathVariable long id) {
        lenderRepo.deleteById(id);
    }
}
