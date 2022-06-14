package com.elgars.klptraining.repository;

import com.elgars.klptraining.repository.model.Lake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LakeRepository extends JpaRepository<Lake, Long> {

    Optional<Lake> findByNameDepthBiggerThan(String name, Integer depth);

}
