package com.example.testTask.controllers;

import com.example.testTask.dto.FridgeParams;
import com.example.testTask.models.Fridge;
import com.example.testTask.services.FridgeServiceInterface;
import com.example.testTask.services.impl.CreateCurrentModelService;
import com.example.testTask.specifications.FridgeSpecification;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@AllArgsConstructor
public class FridgeController {

    CreateCurrentModelService createCurrentModelService;
    FridgeSpecification fridgeSpecification;
    FridgeServiceInterface fridgeService;

    @GetMapping(value= "/models", params = "type=fridge")
    public ResponseEntity<List<Fridge>> getFridges(
            FridgeParams fridgeParams
    )
    {
        Specification<Fridge> spec = fridgeSpecification.build(fridgeParams);
        return ResponseEntity.ok(fridgeService.getAllFridges(spec));
    }
}
