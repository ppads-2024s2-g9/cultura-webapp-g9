package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ItemCulturalRepository extends JpaRepository<ItemCultural, Long>, JpaSpecificationExecutor<ItemCultural> {

  }
