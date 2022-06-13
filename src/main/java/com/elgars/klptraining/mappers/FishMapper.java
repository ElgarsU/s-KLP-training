package com.elgars.klptraining.mappers;

import com.elgars.klptraining.modelDTO.FishDTO;
import com.elgars.klptraining.repository.model.Fish;
import org.springframework.stereotype.Component;

@Component
public class FishMapper {

    public FishDTO fishToFishDTO(Fish fish) {
        return FishDTO.builder()
                .id(fish.getId())
                .name(fish.getName())
                .restricted(fish.getRestricted())
                .build();
    }

    public Fish fishDTOtoFish(FishDTO fishDTO) {
        return Fish.builder()
                .id(fishDTO.getId())
                .name(fishDTO.getName())
                .restricted(fishDTO.getRestricted())
                .build();

    }
}
