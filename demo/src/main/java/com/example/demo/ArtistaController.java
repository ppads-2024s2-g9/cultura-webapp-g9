package com.example.demo;

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
class ArtistaController {

	@Autowired
	private ArtistaRepo ArtistaRepo;

	public ArtistaController() {

	}

	@GetMapping("/api/artistas")
	Iterable<Artista> getArtistas(@RequestParam Optional<Long> faculdadeId) {

		return ArtistaRepo.findAll();

	}

	@GetMapping("/api/Artistas/{id}")
	Optional<Artista> getArtista(@PathVariable long id) {
		return ArtistaRepo.findById(id);
	}

	@PostMapping("/api/Artistas")
	Artista createArtista(@RequestBody Artista p) {
		Artista createdProf = ArtistaRepo.save(p);
		return createdProf;
	}

	@PutMapping("/api/Artistas/{ArtistaId}")
	Optional<Artista> updateArtista(@RequestBody Artista ArtistaRequest, @PathVariable long ArtistaId) {
		Optional<Artista> opt = ArtistaRepo.findById(ArtistaId);
		if (opt.isPresent()) {
			if (ArtistaRequest.getId() == ArtistaId) {
				ArtistaRepo.save(ArtistaRequest);
				return opt;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Erro ao alterar dados do Artista com id " + ArtistaId);
	}

	@DeleteMapping(value = "/api/Artistas/{id}")
	void deleteArtista(@PathVariable long id) {
		ArtistaRepo.deleteById(id);
	}
}