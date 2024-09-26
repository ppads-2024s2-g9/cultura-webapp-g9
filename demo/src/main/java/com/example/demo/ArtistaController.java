package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

    private List<Artista> artistas = new ArrayList<>();

    @GetMapping
    public List<Artista> listarArtistas() {
        return artistas;
    }

    @GetMapping("/{nomeArtistico}")
    public ResponseEntity<Artista> buscarArtista(@PathVariable String nomeArtistico) {
        for (Artista artista : artistas) {
            if (artista.getnomeArtistico().equalsIgnoreCase(nomeArtistico)) {
                return ResponseEntity.ok(artista);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Artista> criarArtista(@RequestBody Artista artista) {
        artistas.add(artista);
        return ResponseEntity.status(HttpStatus.CREATED).body(artista);
    }

    @PutMapping("/{nomeArtistico}")
    public ResponseEntity<Artista> atualizarArtista(@PathVariable String nomeArtistico, @RequestBody Artista artistaAtualizado) {
        for (int i = 0; i < artistas.size(); i++) {
            Artista artista = artistas.get(i);
            if (artista.getnomeArtistico().equalsIgnoreCase(nomeArtistico)) {
                artistas.set(i, artistaAtualizado);
                return ResponseEntity.ok(artistaAtualizado);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{nomeArtistico}")
    public ResponseEntity<Void> deletarArtista(@PathVariable String nomeArtistico) {
        for (int i = 0; i < artistas.size(); i++) {
            Artista artista = artistas.get(i);
            if (artista.getnomeArtistico().equalsIgnoreCase(nomeArtistico)) {
                artistas.remove(i);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
