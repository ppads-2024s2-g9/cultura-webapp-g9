package com.example.demo;

import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepo extends CrudRepository<Artista, Long> {
}
