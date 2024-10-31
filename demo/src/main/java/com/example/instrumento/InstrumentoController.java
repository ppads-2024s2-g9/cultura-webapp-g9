package com.example.instrumento;

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
class InstrumentoController {

	@Autowired
	private Instrumento instrumentoRepo;

	public InstrumentoController() {

	}

	@GetMapping("/api/instrumento")
	Iterable<Instrumento> getInstrumento(@RequestParam Optional<Long> instrumentoId) {

		return instrumentoRepo.findAll();

	}

	@GetMapping("/api/instrumento/{id}")
	Optional<Instrumento> getInstrumento(@PathVariable long id) {
		return instrumentoRepo.findById(id);
	}

	@PostMapping("/api/instrumento")
	Instrumento createInstrumento(@RequestBody Instrumento p) {
		Instrumento createdinstrumento = instrumentoRepo.save(p);
		return createdinstrumento;
	}

	@PutMapping("/api/instrumento/{instrumentoId}")
	Optional<Instrumento> updateInstrumento(@RequestBody Instrumento instrumentoRequest, @PathVariable long instrumentoId) {
		Optional<Instrumento> opt = instrumentoRepo.findById(instrumentoId);
		if (opt.isPresent()) {
			if (instrumentoRequest.getId() == instrumentoId) {
				instrumentoRepo.save(instrumentoRequest);
				return opt;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Erro ao alterar dados do instrumento com id " + instrumentoId);
	}

	@DeleteMapping(value = "/api/instrumento/{id}")
	void deleteInstrumento(@PathVariable long id) {
		instrumentoRepo.deleteById(id);
	}
}