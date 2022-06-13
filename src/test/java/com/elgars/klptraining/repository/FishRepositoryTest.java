package com.elgars.klptraining.repository;

import com.elgars.klptraining.repository.model.Fish;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FishRepositoryTest {

    private final Long id = 1L;
    private final String name = "fish";
    private final Boolean restricted = false;
    private final FishRepository repository;

//TODO in this context, without autowired tests does not work
    @Autowired
    public FishRepositoryTest (FishRepository repository) {
        this.repository = repository;
    }

    @Test
    void saveAndReturn() {
        Fish fish = Fish.builder().name(name).restricted(restricted).build();

        Fish savedFish = repository.save(fish);

        assertEquals(name, savedFish.getName());
        assertEquals(restricted, savedFish.getRestricted());
    }
}