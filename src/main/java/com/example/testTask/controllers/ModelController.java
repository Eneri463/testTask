package com.example.testTask.controllers;

import com.example.testTask.models.*;
import com.example.testTask.services.*;
import com.example.testTask.specifications.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(value= "/models", params = {"!type","!search"})
    public ResponseEntity<List<Model>> getAllAppliances(
            @RequestParam(name = "country", required = false) String country,
            @RequestParam(name = "company", required = false) String company,
            @RequestParam(name = "online", required = false) Boolean online,
            @RequestParam(name = "installment", required = false) Boolean installment,
            @RequestParam(name = "min_price", required = false) Double priceMin,
            @RequestParam(name = "max_price", required = false) Double priceMax,
            @RequestParam(name = "colour", required = false) String colour,
            @RequestParam(name = "sort", defaultValue = "name,asc") String orderBy
            )
    {

        Specification<Model> spec = GeneralSpecification.mainFilters(country, company, online, installment, priceMin, priceMax, colour, orderBy);
        return ResponseEntity.ok(allModelsService.getAllModels(spec));
    }

    @GetMapping(value= "/models", params = {"type=television", "!search"})
    public ResponseEntity<List<Television>> getTelevisions(
            @RequestParam(name = "country", required = false) String country,
            @RequestParam(name = "company", required = false) String company,
            @RequestParam(name = "online", required = false) Boolean online,
            @RequestParam(name = "installment", required = false) Boolean installment,
            @RequestParam(name = "min_price", required = false) Double priceMin,
            @RequestParam(name = "max_price", required = false) Double priceMax,
            @RequestParam(name = "colour", required = false) String colour,
            @RequestParam(name = "category", required = false) String category,
            @RequestParam(name = "technology", required = false) String technology,
            @RequestParam(name = "sort", defaultValue = "name,asc") String orderBy
    )
    {
        Specification<Television> spec = televisionSpecification.build(country, company, online, installment, priceMin, priceMax, colour, orderBy, category, technology);
        return ResponseEntity.ok(televisionService.getAllTelevisions(spec));
    }

    @GetMapping(value= "/models", params = {"type=vacuumCleaner", "!search"})
    public ResponseEntity<List<VacuumCleaner>> getVacuumCleaners(
            @RequestParam(name = "country", required = false) String country,
            @RequestParam(name = "company", required = false) String company,
            @RequestParam(name = "online", required = false) Boolean online,
            @RequestParam(name = "installment", required = false) Boolean installment,
            @RequestParam(name = "min_price", required = false) Double priceMin,
            @RequestParam(name = "max_price", required = false) Double priceMax,
            @RequestParam(name = "colour", required = false) String colour,
            @RequestParam(name = "volume", required = false) Integer volume,
            @RequestParam(name = "number_of_modes", required = false) Integer numberOfModes,
            @RequestParam(name = "sort", defaultValue = "name,asc") String orderBy
    )
    {
        Specification<VacuumCleaner> spec = vacuumCleanerSpecification.build(country, company, online, installment, priceMin, priceMax, colour, orderBy, volume, numberOfModes);
        return ResponseEntity.ok(vacuumCleanerService.getAllVacuumCleaners(spec));
    }

    @GetMapping(value= "/models", params = {"type=fridge", "!search"})
    public ResponseEntity<List<Fridge>> getFridges(
            @RequestParam(name = "country", required = false) String country,
            @RequestParam(name = "company", required = false) String company,
            @RequestParam(name = "online", required = false) Boolean online,
            @RequestParam(name = "installment", required = false) Boolean installment,
            @RequestParam(name = "min_price", required = false) Double priceMin,
            @RequestParam(name = "max_price", required = false) Double priceMax,
            @RequestParam(name = "colour", required = false) String colour,
            @RequestParam(name = "number_of_doors", required = false) Integer numberOfDoors,
            @RequestParam(name = "compressor", required = false) String compressorType,
            @RequestParam(name = "sort", defaultValue = "name,asc") String orderBy
    )
    {
        Specification<Fridge> spec = fridgeSpecification.build(country, company, online, installment, priceMin, priceMax, colour, orderBy, numberOfDoors, compressorType);
        return ResponseEntity.ok(fridgeService.getAllFridges(spec));
    }

    @GetMapping(value= "/models", params = {"type=smartphone", "!search"})
    public ResponseEntity<List<Smartphone>> getSmartphones(
            @RequestParam(name = "country", required = false) String country,
            @RequestParam(name = "company", required = false) String company,
            @RequestParam(name = "online", required = false) Boolean online,
            @RequestParam(name = "installment", required = false) Boolean installment,
            @RequestParam(name = "min_price", required = false) Double priceMin,
            @RequestParam(name = "max_price", required = false) Double priceMax,
            @RequestParam(name = "colour", required = false) String colour,
            @RequestParam(name = "number_of_cameras", required = false) Integer numberOfCameras,
            @RequestParam(name = "memory_size", required = false) Integer memorySize,
            @RequestParam(name = "sort", defaultValue = "name,asc") String orderBy
    )
    {
        Specification<Smartphone> spec = smartphoneSpecification.build(country, company, online, installment, priceMin, priceMax, colour, orderBy, numberOfCameras, memorySize);
        return ResponseEntity.ok(smartphoneService.getAllSmartphones(spec));
    }

    @GetMapping(value= "/models", params = {"type=computer", "!search"})
    public ResponseEntity<List<Computer>> getComputers(
            @RequestParam(name = "country", required = false) String country,
            @RequestParam(name = "company", required = false) String company,
            @RequestParam(name = "online", required = false) Boolean online,
            @RequestParam(name = "installment", required = false) Boolean installment,
            @RequestParam(name = "min_price", required = false) Double priceMin,
            @RequestParam(name = "max_price", required = false) Double priceMax,
            @RequestParam(name = "colour", required = false) String colour,
            @RequestParam(name = "category", required = false) String category,
            @RequestParam(name = "processor", required = false) String processorType,
            @RequestParam(name = "sort", defaultValue = "name,asc") String orderBy
    )
    {
        Specification<Computer> spec = computerSpecification.build(country, company, online, installment, priceMin, priceMax, colour, orderBy, category, processorType);
        return ResponseEntity.ok(computerService.getAllComputers(spec));
    }

}
