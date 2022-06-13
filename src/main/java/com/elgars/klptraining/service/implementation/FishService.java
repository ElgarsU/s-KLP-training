package com.elgars.klptraining.service.implementation;

import com.elgars.klptraining.mappers.FishMapper;
import com.elgars.klptraining.modelDTO.FishDTO;
import com.elgars.klptraining.repository.FishRepository;
import com.elgars.klptraining.repository.model.Fish;
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
    public FishDTO getFish(Long id) {
        Optional<Fish> fish = repository.findById(id);
        FishDTO fishDTO = null;
        if (fish.isPresent()) {
            fishDTO = mapper.fishToFishDTO(fish.get());
        }
        return fishDTO;
    }

    @Override
    public FishDTO getFishByName(String name) {
        Optional<Fish> fish = repository.findByName(name);
        FishDTO fishDTO = null;
        if (fish.isPresent()) {
            fishDTO = mapper.fishToFishDTO(fish.get());
        }
        return fishDTO;
    }

    @Override
    public List<FishDTO> getAllFishes() {
        List<Fish> fishList = repository.findAll();
        List<FishDTO> fishDTOList = null;
        if (!fishList.isEmpty()) {
            fishDTOList = fishList.stream()
                    .map(mapper::fishToFishDTO)
                    .collect(Collectors.toList());
        }
        return fishDTOList;
    }

    @Override
    public FishDTO saveFish(FishDTO fishDTO) {
        Fish savedFish = repository.save(mapper.fishDTOtoFish(fishDTO));
        return mapper.fishToFishDTO(savedFish);
    }

    @Override
    public void deleteFish(Long id) {
        Optional<Fish> fish = repository.findById(id);
        if (fish.isPresent()) {
            repository.deleteById(id);
        }
    }
}
