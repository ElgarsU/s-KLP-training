package com.elgars.klptraining.service;

import com.elgars.klptraining.modelDTO.FishItem;

import java.util.List;

public interface FishServiceInterface {

    FishItem getFish(Long id);

    FishItem getFishByName(String name);

    List<FishItem> getAllFishes();

    FishItem saveFish(FishItem fishItem);

    void deleteFishByID(Long id);
}
