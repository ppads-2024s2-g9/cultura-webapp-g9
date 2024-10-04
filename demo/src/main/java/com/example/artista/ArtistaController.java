package com.example.artista;

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
	private ArtistaRepo artistaRepo;

	public ArtistaController() {

	}

	@GetMapping("/api/artista")
	Iterable<Artista> getArtistas(@RequestParam Optional<Long> artistaId) {

		return artistaRepo.findAll();

	}

	@GetMapping("/api/artista/{id}")
	Optional<Artista> getArtista(@PathVariable long id) {
		return ArtistaRepo.findById(id);
	}

	@PostMapping("/api/artista")
	Artista createArtista(@RequestBody Artista p) {
		Artista createdArtista = artistaRepo.save(p);
		return createdArtista;
	}

	@PutMapping("/api/artista/{artistaId}")
	Optional<Artista> updateArtista(@RequestBody Artista artistaRequest, @PathVariable long artistaId) {
		Optional<Artista> opt = artistaRepo.findById(artistaId);
		if (opt.isPresent()) {
			if (artistaRequest.getId() == artistaId) {
				artistaRepo.save(artistaRequest);
				return opt;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Erro ao alterar dados do artista com id " + artistaId);
	}

	@DeleteMapping(value = "/api/artista/{id}")
	void deleteArtista(@PathVariable long id) {
		artistaRepo.deleteById(id);
	}
}