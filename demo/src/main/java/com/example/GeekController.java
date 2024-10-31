package com.example;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/geeks")
public class GeekController {

    private final GeekRepository geekRepository;

    @Autowired
    public GeekController(GeekRepository geekRepository) {
        this.geekRepository = geekRepository;
    }

    @GetMapping("/api/geeks")
    Iterable<Geek> getGeeks(@RequestParam Optional<Long> geekId) {
        return geekRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Geek> getGeek(@PathVariable Long id) {
        return geekRepository.findById(id)
            .map(geek -> ResponseEntity.ok(geek))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Geek não encontrado com id " + id));
    }

    @PostMapping
    public ResponseEntity<Geek> createGeek(@RequestBody Geek geek) {
        geek.setCreatedAt(Instant.now());
        Geek createdGeek = geekRepository.save(geek);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGeek);
    }

    @PutMapping("/{geekId}")
    public ResponseEntity<Geek> updateGeek(@RequestBody Geek geekRequest, @PathVariable Long geekId) {
        return geekRepository.findById(geekId)
            .map(geekToUpdate -> {
                // Atualize os campos necessários do geekToUpdate com os dados de geekRequest
                geekToUpdate.setNome(geekRequest.getNome());
                geekToUpdate.setEmail(geekRequest.getEmail());
                geekToUpdate.setBio(geekRequest.getBio());
                geekToUpdate.setUpdatedAt(Instant.now()); // Supondo que você tenha esse campo
                Geek updatedGeek = geekRepository.save(geekToUpdate);
                return ResponseEntity.ok(updatedGeek);
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados do geek com id " + geekId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGeek(@PathVariable Long id) {
        if (geekRepository.existsById(id)) {
            geekRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Geek não encontrado com id " + id);
        }
    }
}
