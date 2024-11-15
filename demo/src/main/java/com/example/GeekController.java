package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/geeks")
public class GeekController {

    @Autowired
    private GeekRepository geekRepository;  // Repositório diretamente aqui

    // Criar um novo Geek
    @PostMapping
    public ResponseEntity<Geek> createGeek(@RequestBody Geek geek) {
        Geek savedGeek = geekRepository.save(geek);  // Salvando diretamente no repositório
        return new ResponseEntity<>(savedGeek, HttpStatus.CREATED);
    }

    // Buscar todos os geeks
    @GetMapping
    public ResponseEntity<List<Geek>> getAllGeeks() {
        List<Geek> geeks = geekRepository.findAll();  // Buscando todos os geeks
        return new ResponseEntity<>(geeks, HttpStatus.OK);
    }

    // Buscar Geek por ID
    @GetMapping("/{id}")
    public ResponseEntity<Geek> getGeekById(@PathVariable Long id) {
        Optional<Geek> geek = geekRepository.findById(id);  // Buscando geek por ID
        return geek.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Atualizar um Geek
    @PutMapping("/{id}")
    public ResponseEntity<Geek> updateGeek(@PathVariable Long id, @RequestBody Geek geek) {
        if (!geekRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // Se não encontrar o ID, retorna 404
        }
        geek.setId(id);  // Define o ID no objeto antes de salvar
        Geek updatedGeek = geekRepository.save(geek);  // Atualiza o Geek no repositório
        return ResponseEntity.ok(updatedGeek);  // Retorna o Geek atualizado
    }

    // Excluir um Geek
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGeek(@PathVariable Long id) {
        if (!geekRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // Se não encontrar o ID, retorna 404
        }
        geekRepository.deleteById(id);  // Exclui o Geek do repositório
        return ResponseEntity.noContent().build();  // Retorna 204 No Content
    }
}
