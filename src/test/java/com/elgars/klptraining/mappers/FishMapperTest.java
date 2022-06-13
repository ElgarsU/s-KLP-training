package com.elgars.klptraining.mappers;

import com.elgars.klptraining.modelDTO.FishDTO;
import com.elgars.klptraining.repository.model.Fish;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//TODO annotations for this test?
class FishMapperTest {

    private final Long id = 1L;
    private final String name = "pike";
    private final Boolean restricted = true;
    private final FishMapper mapper = new FishMapper();

    @Test
    void fishToFishDTO() {
        Fish fish = Fish.builder().id(id).name(name).restricted(restricted).build();
        FishDTO fishDTO = mapper.fishToFishDTO(fish);

        assertEquals(fish.getId(), fishDTO.getId(), "The IDs does not match");
        assertEquals(fish.getName(),fishDTO.getName(),"The names does not match");
        assertEquals(fish.getRestricted(),fishDTO.getRestricted(),"The fish status does not match");
    }

    @Test
    void fishDTOtoFish() {
        FishDTO fishDTO = FishDTO.builder().id(id).name(name).restricted(restricted).build();
        Fish fish = mapper.fishDTOtoFish(fishDTO);

        assertEquals(fishDTO.getId(),fish.getId(),"The IDs does not match");
        assertEquals(fishDTO.getName(),fish.getName(),"The names does not match");
        assertEquals(fishDTO.getRestricted(),fish.getRestricted(),"The fish status does not match");
    }
}