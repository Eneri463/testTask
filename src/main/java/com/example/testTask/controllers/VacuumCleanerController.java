package com.example.testTask.controllers;

import com.example.testTask.dto.VacuumCleanerParams;
import com.example.testTask.models.VacuumCleaner;
import com.example.testTask.services.VacuumCleanerServiceInterface;
import com.example.testTask.services.impl.CreateCurrentModelService;
import com.example.testTask.specifications.VacuumCleanerSpecification;
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
public class VacuumCleanerController {

    CreateCurrentModelService createCurrentModelService;
    VacuumCleanerSpecification vacuumCleanerSpecification;
    VacuumCleanerServiceInterface vacuumCleanerService;

    @GetMapping(value= "/models", params = "type=vacuumCleaner")
    public ResponseEntity<List<VacuumCleaner>> getVacuumCleaners(
            VacuumCleanerParams vacuumCleanerParams
    )
    {
        Specification<VacuumCleaner> spec = vacuumCleanerSpecification.build(vacuumCleanerParams);
        return ResponseEntity.ok(vacuumCleanerService.getAllVacuumCleaners(spec));
    }
}
