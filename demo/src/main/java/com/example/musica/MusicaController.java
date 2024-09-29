package com.example.musica;


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
class MusicaController {

	@Autowired
	private MusicaRepo musicaRepo;

	public MusicaController() {

	}

	@GetMapping("/api/musicas")
	Iterable<Musica> getMusicas(@RequestParam Optional<Long> albumId) {
		return musicaRepo.findAll();
	}

	@GetMapping("/api/musicas/{id}")
	Optional<Musica> getMusica(@PathVariable long id) {
		return musicaRepo.findById(id);
	}

	@PostMapping("/api/musicas")
	Musica createMusica(@RequestBody Musica m) {
		Musica createdMusica = musicaRepo.save(m);
		return createdMusica;
	}

	@PutMapping("/api/musicas/{musicaId}")
	Optional<Musica> updateMusica(@RequestBody Musica musicaRequest, @PathVariable long musicaId) {
		Optional<Musica> opt = musicaRepo.findById(musicaId);
		if (opt.isPresent()) {
			if (musicaRequest.getId() == musicaId) {
				musicaRepo.save(musicaRequest);
				return opt;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Erro ao alterar dados da música com id " + musicaId);
	}

	@DeleteMapping(value = "/api/musicas/{id}")
	void deleteMusica(@PathVariable long id) {
		musicaRepo.deleteById(id);
	}
}