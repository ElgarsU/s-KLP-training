package com.elgars.klptraining.service.implementation;

import com.elgars.klptraining.mappers.LakeMapper;
import com.elgars.klptraining.modelDTO.LakeItem;
import com.elgars.klptraining.repository.LakeRepository;
import com.elgars.klptraining.service.LakeServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LakeService implements LakeServiceInterface {

    private final LakeRepository repository;
    private final LakeMapper mapper;

    public LakeService(LakeRepository repository, LakeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public LakeItem getLakeByID(Long id) {
        return repository.findById(id).map(mapper::lakeEntityToLakeItem).orElse(null);
    }

    public List<LakeItem> getLakeMinDepth(Integer depth) {
        return repository.findByDepthGreaterThan(depth)
                .stream()
                .map(mapper::lakeEntityToLakeItem)
                .collect(Collectors.toList());
    }

    @Override
    public List<LakeItem> getAllLakes() {
        return repository.findAll().stream()
                .map(mapper::lakeEntityToLakeItem)
                .collect(Collectors.toList());
    }

    @Override
    public LakeItem saveLake(LakeItem lakeItem) {
        return mapper.lakeEntityToLakeItem(repository.save(mapper.lakeItemToLakeEntity(lakeItem)));
    }

    @Override
    public void deleteLakeByID(Long id) {
        repository.deleteById(id);

    }
}
