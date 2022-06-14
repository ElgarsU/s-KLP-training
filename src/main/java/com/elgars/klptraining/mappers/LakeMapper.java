package com.elgars.klptraining.mappers;

import com.elgars.klptraining.modelDTO.LakeDTO;
import com.elgars.klptraining.repository.model.Lake;
import org.springframework.stereotype.Component;

@Component
public class LakeMapper {

    public LakeDTO lakeToLakeDTO(Lake lake) {
        return LakeDTO.builder()
                .id(lake.getId())
                .name(lake.getName())
                .depth(lake.getDepth())
                .build();
    }

    public Lake lakeDTOtoLake(LakeDTO lakeDTO) {
        return Lake.builder()
                .id(lakeDTO.getId())
                .name(lakeDTO.getName())
                .depth(lakeDTO.getDepth())
                .build();
    }
}
