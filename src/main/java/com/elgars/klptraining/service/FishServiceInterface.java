package com.elgars.klptraining.service;

import com.elgars.klptraining.modelDTO.FishDTO;

import java.util.List;

public interface FishServiceInterface {

    FishDTO getFish(Long id);

    FishDTO getFishByName(String name);

    List<FishDTO> getAllFishes();

    FishDTO saveFish(FishDTO fishDTO);

    void deleteFish(Long id);
}
