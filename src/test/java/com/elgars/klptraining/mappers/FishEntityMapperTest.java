package com.elgars.klptraining.mappers;

import com.elgars.klptraining.modelDTO.FishItem;
import com.elgars.klptraining.repository.model.FishEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//TODO annotations for this test?
class FishEntityMapperTest {

    private final Long id = 1L;
    private final String name = "pike";
    private final Boolean restricted = true;
    private final FishMapper mapper = new FishMapper();

    @Test
    void fishToFishDTO() {
        FishEntity fishEntity = FishEntity.builder().id(id).name(name).restricted(restricted).build();
        FishItem fishItem = mapper.fishEntityToFishItem(fishEntity);

        assertEquals(fishEntity.getId(), fishItem.getId(), "The IDs does not match");
        assertEquals(fishEntity.getName(), fishItem.getName(),"The names does not match");
        assertEquals(fishEntity.getRestricted(), fishItem.getRestricted(),"The fish status does not match");
    }

    @Test
    void fishDTOtoFish() {
        FishItem fishItem = FishItem.builder().id(id).name(name).restricted(restricted).build();
        FishEntity fishEntity = mapper.fishItemToFishEntity(fishItem);

        assertEquals(fishItem.getId(),fishEntity.getId(),"The IDs does not match");
        assertEquals(fishItem.getName(),fishEntity.getName(),"The names does not match");
        assertEquals(fishItem.getRestricted(),fishEntity.getRestricted(),"The fish status does not match");
    }
}