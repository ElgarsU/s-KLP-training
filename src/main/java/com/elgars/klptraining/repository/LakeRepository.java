package com.elgars.klptraining.repository;

import com.elgars.klptraining.repository.model.LakeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LakeRepository extends JpaRepository<LakeEntity, Long> {

    Optional<LakeEntity> findByNameAndDepthGreaterThan(String name, Integer depth);

}
