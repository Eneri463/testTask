package com.example.testTask.controllers;

import com.example.testTask.models.Model;
import com.example.testTask.services.ModelServiceInterface;
import com.example.testTask.specifications.GeneralSpecification;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ModelServiceInterface allModelsService;

    @GetMapping(value= "/models", params = {"!type","search"})
    public String test()
    {
        return "ok";
    }


    @GetMapping(value= "/models", params = {"!type","!search"})
    public ResponseEntity<List<Model>> getAllAppliances(
            @RequestParam(name = "country", required = false) String country,
            @RequestParam(name = "company", required = false) String company,
            @RequestParam(name = "online", required = false) Boolean online,
            @RequestParam(name = "installment", required = false) Boolean installment,
            @RequestParam(name = "min_price", required = false) Double priceMin,
            @RequestParam(name = "max_price", required = false) Double priceMax,
            @RequestParam(name = "colour", required = false) String colour,
            @RequestParam(name = "orderBy", defaultValue = "name,asc") String orderBy
            )
    {


        Specification<Model> spec = GeneralSpecification.filter(country, company, online, installment, priceMin, priceMax, colour, orderBy);

        return ResponseEntity.ok(allModelsService.getAllModels(spec));
    }

    @GetMapping(value= "/models", params = {"type=television", "!search"})
    public ResponseEntity<List<Model>> getTelevisions(
            @RequestParam(name = "type") String type,
            @RequestParam(name = "country", required = false) String country,
            @RequestParam(name = "company", required = false) String company,
            @RequestParam(name = "online", required = false) Boolean online,
            @RequestParam(name = "installment", required = false) Boolean installment,
            @RequestParam(name = "min_price", required = false) Double priceMin,
            @RequestParam(name = "max_price", required = false) Double priceMax,
            @RequestParam(name = "colour", required = false) String colour,
            @RequestParam(name = "orderBy", defaultValue = "name,asc") String orderBy
    )
    {


        //Specification<Model> spec = GeneralSpecification.filter(postParamsDTO);

        //return allModelsService.getAllModels(spec);

        return ResponseEntity.ok(null);
    }

    @GetMapping(value= "/models", params = {"type=vacuumCleaner", "!search"})
    public ResponseEntity<List<Model>> getVacuumCleaners(
            @RequestParam(name = "country", required = false) String country,
            @RequestParam(name = "company", required = false) String company,
            @RequestParam(name = "online", required = false) Boolean online,
            @RequestParam(name = "installment", required = false) Boolean installment,
            @RequestParam(name = "min_price", required = false) Double priceMin,
            @RequestParam(name = "max_price", required = false) Double priceMax,
            @RequestParam(name = "colour", required = false) String colour,
            @RequestParam(name = "orderBy", defaultValue = "name,asc") String orderBy
    )
    {


        //Specification<Model> spec = GeneralSpecification.filter(postParamsDTO);

        //return allModelsService.getAllModels(spec);

        return ResponseEntity.ok(null);
    }

}
