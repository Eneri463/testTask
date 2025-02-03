package com.example.testTask.controllers;

import com.example.testTask.dto.*;
import com.example.testTask.models.*;
import com.example.testTask.services.*;
import com.example.testTask.specifications.*;
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
public class ModelController {

    TelevisionSpecification televisionSpecification;
    VacuumCleanerSpecification vacuumCleanerSpecification;
    FridgeSpecification fridgeSpecification;
    SmartphoneSpecification smartphoneSpecification;
    ComputerSpecification computerSpecification;

    ModelServiceInterface allModelsService;
    TelevisionServiceInterface televisionService;
    VacuumCleanerServiceInterface vacuumCleanerService;
    FridgeServiceInterface fridgeService;
    SmartphoneServiceInterface smartphoneService;
    ComputerServiceInterface computerService;

    @GetMapping(value= "/models", params = "!type")
    public ResponseEntity<List<Model>> getAllAppliances(
            PostParamsDTO postParamsDTO
    )
    {
        Specification<Model> spec = GeneralSpecification.mainFilters(postParamsDTO);
        return ResponseEntity.ok(allModelsService.getAllModels(spec));
    }

    @GetMapping(value= "/models", params = "type=television")
    public ResponseEntity<List<Television>> getTelevisions(
            TelevisionParams televisionParams
    )
    {
        Specification<Television> spec = televisionSpecification.build(televisionParams);
        return ResponseEntity.ok(televisionService.getAllTelevisions(spec));
    }

    @GetMapping(value= "/models", params = "type=vacuumCleaner")
    public ResponseEntity<List<VacuumCleaner>> getVacuumCleaners(
            VacuumCleanerParams vacuumCleanerParams
    )
    {
        Specification<VacuumCleaner> spec = vacuumCleanerSpecification.build(vacuumCleanerParams);
        return ResponseEntity.ok(vacuumCleanerService.getAllVacuumCleaners(spec));
    }

    @GetMapping(value= "/models", params = "type=fridge")
    public ResponseEntity<List<Fridge>> getFridges(
            FridgeParams fridgeParams
    )
    {
        Specification<Fridge> spec = fridgeSpecification.build(fridgeParams);
        return ResponseEntity.ok(fridgeService.getAllFridges(spec));
    }

    @GetMapping(value= "/models", params = "type=smartphone")
    public ResponseEntity<List<Smartphone>> getSmartphones(
            SmartphonesParams smartphonesParams
    )
    {
        Specification<Smartphone> spec = smartphoneSpecification.build(smartphonesParams);
        return ResponseEntity.ok(smartphoneService.getAllSmartphones(spec));
    }

    @GetMapping(value= "/models", params = "type=computer")
    public ResponseEntity<List<Computer>> getComputers(
            ComputerParams computerParams
    )
    {
        Specification<Computer> spec = computerSpecification.build(computerParams);
        return ResponseEntity.ok(computerService.getAllComputers(spec));
    }

}
