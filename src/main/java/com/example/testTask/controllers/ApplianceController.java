package com.example.testTask.controllers;

import com.example.testTask.dto.PostParamsDTO;
import com.example.testTask.models.Appliance;
import com.example.testTask.models.Model;
import com.example.testTask.services.ApplianceServiceInterface;
import com.example.testTask.services.ApplianceTypeServiceInterface;
import com.example.testTask.specifications.GeneralSpecification;
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
public class ApplianceController {

    ApplianceServiceInterface applianceService;
    ApplianceTypeServiceInterface applianceTypeService;

    @GetMapping(value= "/test")
    public ResponseEntity<List<Appliance>> getAllAppliances(
            @RequestParam(name = "name") String name

    )
    {
        var p = applianceTypeService.getByName(name);
        return ResponseEntity.ok(null);
    }

}
