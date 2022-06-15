package com.elgars.klptraining.repository;

import com.elgars.klptraining.repository.model.FishEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FishEntityRepositoryTest {

    private final Long id = 1L;
    private final String name = "fish";
    private final Boolean restricted = false;
    private final FishRepository repository;

    @Autowired
    public FishEntityRepositoryTest(FishRepository repository) {
        this.repository = repository;
    }

    @Test
    void saveAndReturn() {
        FishEntity fish = FishEntity.builder().name(name).restricted(restricted).build();

        FishEntity savedFish = repository.save(fish);

        assertEquals(name, savedFish.getName());
        assertEquals(restricted, savedFish.getRestricted());
    }
}