package com.example.testTask.controllers;

import com.example.testTask.dto.ComputerParams;
import com.example.testTask.models.Computer;
import com.example.testTask.services.ComputerServiceInterface;
import com.example.testTask.services.impl.CreateCurrentModelService;
import com.example.testTask.specifications.ComputerSpecification;
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
public class ComputerController {

    CreateCurrentModelService createCurrentModelService;
    ComputerSpecification computerSpecification;
    ComputerServiceInterface computerService;

    @GetMapping(value= "/models", params = "type=computer")
    public ResponseEntity<List<Computer>> getComputers(
            ComputerParams computerParams
    )
    {
        Specification<Computer> spec = computerSpecification.build(computerParams);
        return ResponseEntity.ok(computerService.getAllComputers(spec));
    }
}
