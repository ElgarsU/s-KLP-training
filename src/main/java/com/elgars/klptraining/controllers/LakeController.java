package com.elgars.klptraining.controllers;

import com.elgars.klptraining.modelDTO.LakeItem;
import com.elgars.klptraining.service.implementation.LakeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class LakeController {

    private final LakeService service;

    public LakeController(LakeService service) {
        this.service = service;
    }

    @GetMapping("/lakes")
    public ResponseEntity<List<LakeItem>> getAllLakes() {
        List<LakeItem> allLakes = service.getAllLakes();
        return new ResponseEntity<>(allLakes, HttpStatus.OK);
    }

    @GetMapping("/lakes/{id}")
    public ResponseEntity<LakeItem> getLakeByID(@PathVariable Long id) {
        LakeItem lake = service.getLakeByID(id);
        return new ResponseEntity<>(lake, HttpStatus.OK);
    }

    @GetMapping("lakes/byDepth/{minDepth}")
    public ResponseEntity<List<LakeItem>> getLakeByNameAndMinDepth(@PathVariable Integer minDepth) {
        List<LakeItem> lake = service.getLakeMinDepth(minDepth);
        return new ResponseEntity<>(lake, HttpStatus.OK);
    }

    @PostMapping("/lakes")
    public ResponseEntity<LakeItem> saveLake(@RequestBody LakeItem lake) {
        LakeItem savedLake = service.saveLake(lake);
        return new ResponseEntity<>(savedLake, HttpStatus.OK);
    }

    @DeleteMapping("/lakes/{id}")
    public void deleteLakeByID(@PathVariable Long id) {
        service.deleteLakeByID(id);
    }
}
