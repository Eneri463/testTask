package com.example.testTask.controllers;

import com.example.testTask.dto.SmartphoneParams;
import com.example.testTask.models.Smartphone;
import com.example.testTask.services.SmartphoneServiceInterface;
import com.example.testTask.services.impl.CreateCurrentModelService;
import com.example.testTask.specifications.SmartphoneSpecification;
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
public class SmartphoneController {

    CreateCurrentModelService createCurrentModelService;
    SmartphoneSpecification smartphoneSpecification;
    SmartphoneServiceInterface smartphoneService;

    @GetMapping(value= "/models", params = "type=smartphone")
    public ResponseEntity<List<Smartphone>> getSmartphones(
            SmartphoneParams smartphoneParams
    )
    {
        Specification<Smartphone> spec = smartphoneSpecification.build(smartphoneParams);
        return ResponseEntity.ok(smartphoneService.getAllSmartphones(spec));
    }
}
