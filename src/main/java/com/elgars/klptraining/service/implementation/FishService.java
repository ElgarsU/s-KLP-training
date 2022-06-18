package com.elgars.klptraining.service.implementation;

import com.elgars.klptraining.mappers.FishMapper;
import com.elgars.klptraining.modelDTO.FishItem;
import com.elgars.klptraining.repository.FishRepository;
import com.elgars.klptraining.repository.model.FishEntity;
import com.elgars.klptraining.service.FishServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FishService implements FishServiceInterface {

    private final FishRepository repository;
    private final FishMapper mapper;

    public FishService (FishRepository repository, FishMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public FishItem getFishByID(Long id) {
        Optional<FishEntity> fish = repository.findById(id);
        FishItem fishItem = null;
        if (fish.isPresent()) {
            fishItem = mapper.fishEntityToFishItem(fish.get());
        }
        return fishItem;
    }

    @Override
    public FishItem getFishByName(String name) {
        Optional<FishEntity> fish = repository.findByNameContaining(name);
        FishItem fishItem = null;
        if (fish.isPresent()) {
            fishItem = mapper.fishEntityToFishItem(fish.get());
        }
        return fishItem;
    }

    @Override
    public List<FishItem> getAllFishes() {
        List<FishEntity> fishList = repository.findAll();
        List<FishItem> fishItemList = null;
        if (!fishList.isEmpty()) {
            fishItemList = fishList.stream()
                    .map(mapper::fishEntityToFishItem)
                    .collect(Collectors.toList());
        }
        return fishItemList;
    }

    @Override
    public FishItem saveFish(FishItem fishItem) {
        FishEntity savedFish = repository.save(mapper.fishItemToFishEntity(fishItem));
        return mapper.fishEntityToFishItem(savedFish);
    }

    @Override
    public void deleteFishByID(Long id) {
        Optional<FishEntity> fish = repository.findById(id);
        if (fish.isPresent()) {
            repository.deleteById(id);
        }
    }
}
