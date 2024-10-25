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
class GeekController {

    @Autowired
    private GeekRepository geekRepository;

    public GeekController() {
    }

    @GetMapping("/api/geeks")
    Iterable<Geek> getGeeks(@RequestParam Optional<Long> geekId) {
        return geekRepository.findAll();
    }

    @GetMapping("/api/geeks/{id}")
    Optional<Geek> getGeek(@PathVariable Long id) {
        return geekRepository.findById(id);
    }

    @PostMapping("/api/geeks")
    Geek createGeek(@RequestBody Geek geek) {
        return geekRepository.save(geek);
    }

    @PutMapping("/api/geeks/{geekId}")
    Optional<Geek> updateGeek(@RequestBody Geek geekRequest, @PathVariable Long geekId) {
        Optional<Geek> opt = geekRepository.findById(geekId);
        if (opt.isPresent()) {
            if (geekRequest.getId() == geekId) {
                return Optional.of(geekRepository.save(geekRequest));
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Erro ao alterar dados do geek com id " + geekId);
    }

    @DeleteMapping(value = "/api/geeks/{id}")
    void deleteGeek(@PathVariable Long id) {
        geekRepository.deleteById(id);
    }
}
