package com.elgars.klptraining.mappers;

import com.elgars.klptraining.modelDTO.LakeItem;
import com.elgars.klptraining.repository.model.LakeEntity;
import org.springframework.stereotype.Component;

@Component
public class LakeMapper {

    public LakeItem lakeEntityToLakeItem(LakeEntity lakeEntity) {
        return LakeItem.builder()
                .id(lakeEntity.getId())
                .name(lakeEntity.getName())
                .depth(lakeEntity.getDepth())
                .build();
    }

    public LakeEntity lakeItemToLakeEntity(LakeItem lakeItem) {
        return LakeEntity.builder()
                .id(lakeItem.getId())
                .name(lakeItem.getName())
                .depth(lakeItem.getDepth())
                .build();
    }

    public LakeEntity saveLakeItemToLakeEntity(LakeItem lakeItem) {
        return LakeEntity.builder()
                .id(lakeItem.getId())
                .name(lakeItem.getName())
                .depth(lakeItem.getDepth())
                .build();
    }
}
