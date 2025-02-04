package com.example.testTask.controllers;

import com.example.testTask.dto.ComputerDTO;
import com.example.testTask.dto.ComputerParams;
import com.example.testTask.dto.ComputerRequestDTO;
import com.example.testTask.dto.ModelRequestDTO;
import com.example.testTask.models.Computer;
import com.example.testTask.models.ComputerCategory;
import com.example.testTask.models.ComputerProcessorType;
import com.example.testTask.models.Model;
import com.example.testTask.services.ComputerCategoryServiceInterface;
import com.example.testTask.services.ComputerProcessorTypeServiceInterface;
import com.example.testTask.services.ComputerServiceInterface;
import com.example.testTask.services.impl.CreateCurrentModelService;
import com.example.testTask.specifications.ComputerSpecification;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@AllArgsConstructor
public class ComputerController {

    private CreateCurrentModelService createCurrentModelService;
    private ComputerSpecification computerSpecification;
    private ComputerServiceInterface computerService;
    private ComputerCategoryServiceInterface computerCategoryService;
    private ComputerProcessorTypeServiceInterface computerProcessorTypeService;

    @GetMapping(value= "/models", params = "type=computer")
    public ResponseEntity<List<Computer>> getComputers(
            ComputerParams computerParams
    )
    {
        Specification<Computer> spec = computerSpecification.build(computerParams);
        return ResponseEntity.ok(computerService.getAllComputers(spec));
    }

    @PostMapping("/model/create/computer")
    @Valid
    public ResponseEntity<ComputerDTO> createComputer(ComputerRequestDTO request)
    {
        ComputerCategory category = computerCategoryService.getByName(request.getCategory());

        if (category == null)
            computerCategoryService.create(new ComputerCategory(null, request.getCategory()));

        ComputerProcessorType processorType = computerProcessorTypeService.getByName(request.getProcessor());

        if (processorType == null)
            computerProcessorTypeService.create(new ComputerProcessorType(null, request.getProcessor()));

        Model model = createCurrentModelService.createModel(request);

        Computer computer = new Computer(null, category, processorType, model);

        return new ResponseEntity<>(computerService.create(computer).createDTO(), HttpStatus.CREATED);
    }
}
