package com.elgars.klptraining.service.implementation;

import com.elgars.klptraining.modelDTO.LakeItem;
import com.elgars.klptraining.service.LakeServiceInterface;

import java.util.List;

public class LakeService implements LakeServiceInterface {

    @Override
    public LakeItem getLake() {
        return null;
    }

    @Override
    public LakeItem getLakeByNameDepthBiggerThan(String name, Integer depth) {
        return null;
    }

    @Override
    public List<LakeItem> getAllLakes() {
        return null;
    }

    @Override
    public LakeItem saveLake(LakeItem lakeItem) {
        return null;
    }

    @Override
    public void deleteLakeByID(Long id) {

    }
}
