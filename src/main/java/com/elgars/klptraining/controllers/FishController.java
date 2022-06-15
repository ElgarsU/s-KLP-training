package com.elgars.klptraining.controllers;

import com.elgars.klptraining.modelDTO.FishItem;
import com.elgars.klptraining.service.implementation.FishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class FishController {

    private final FishService service;

    public FishController (FishService service) {
        this.service = service;
    }

    @GetMapping("/fishes/{name}")
    public ResponseEntity<FishItem> findFishNamed(@PathVariable String name) {
        FishItem namedFish = service.getFishByName(name);
        return new ResponseEntity<>(namedFish, HttpStatus.OK);
    }

    @GetMapping("/fishes")
    public List<FishItem> gitAllFishes() {
        return service.getAllFishes();
    }

}
