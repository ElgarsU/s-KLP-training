package com.elgars.klptraining.repository;

import com.elgars.klptraining.repository.model.LakeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LakeRepository extends JpaRepository<LakeEntity, Long> {

    //Optional<Lake> findByNameDepthBiggerThan(String name, Integer depth);

}
