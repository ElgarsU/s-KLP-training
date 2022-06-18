package com.elgars.klptraining.service;

import com.elgars.klptraining.modelDTO.LakeItem;

import java.util.List;

public interface LakeServiceInterface {

    LakeItem getLakeByID(Long ID);

    List<LakeItem> getLakeMinDepth(Integer depth);

    List<LakeItem> getAllLakes();

    LakeItem saveLake(LakeItem lakeItem);

    void deleteLakeByID(Long id);
}
