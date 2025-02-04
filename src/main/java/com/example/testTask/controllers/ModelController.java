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
    private ModelServiceInterface modelService;

    @GetMapping(value= "/models", params = "!type")
    public ResponseEntity<List<Model>> getAllAppliances(
            ParamsDTO paramsDTO
    )
    {
        Specification<Model> spec = GeneralSpecification.mainFilters(paramsDTO);
        return ResponseEntity.ok(modelService.getAllModels(spec));
    }

}
