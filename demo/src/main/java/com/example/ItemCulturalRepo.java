package com.example;

import org.springframework.data.repository.CrudRepository;

public interface ItemCulturalRepo<T extends ItemCultural> extends CrudRepository<T, Long> {
}
