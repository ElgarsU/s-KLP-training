package com.elgars.klptraining.mappers;

import com.elgars.klptraining.modelDTO.FishItem;
import com.elgars.klptraining.repository.model.FishEntity;
import org.springframework.stereotype.Component;

@Component
public class FishMapper {

    public FishItem fishEntityToFishItem(FishEntity fish) {
        return FishItem.builder()
                .id(fish.getId())
                .name(fish.getName())
                .restricted(fish.getRestricted())
                .build();
    }

    public FishEntity fishItemToFishEntity(FishItem fishItem) {
        return FishEntity.builder()
                .id(fishItem.getId())
                .name(fishItem.getName())
                .restricted(fishItem.getRestricted())
                .build();
    }
}
