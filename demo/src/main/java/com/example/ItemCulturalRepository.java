package com.example.itemcultural;

import org.springframework.data.repository.CrudRepository;

public interface ItemCulturalRepo<T extends ItemCultural> extends CrudRepository<T, Long> {
}
