package com.elgars.klptraining.repository;

import com.elgars.klptraining.repository.model.FishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FishRepository extends JpaRepository<FishEntity, Long> {

    Optional<FishEntity> findByNameContaining(String name);
}
