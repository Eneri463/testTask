package com.example.testTask.controllers;

import com.example.testTask.dto.FridgeDTO;
import com.example.testTask.dto.FridgeParams;
import com.example.testTask.dto.FridgeRequestDTO;
import com.example.testTask.models.Fridge;
import com.example.testTask.models.FridgeCompressorType;
import com.example.testTask.models.Model;
import com.example.testTask.services.FridgeCompressorTypeServiceInterface;
import com.example.testTask.services.FridgeServiceInterface;
import com.example.testTask.services.impl.CreateCurrentModelService;
import com.example.testTask.specifications.FridgeSpecification;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@AllArgsConstructor
public class FridgeController {

    private CreateCurrentModelService createCurrentModelService;
    private FridgeSpecification fridgeSpecification;
    private FridgeServiceInterface fridgeService;
    private FridgeCompressorTypeServiceInterface fridgeCompressorTypeService;

    @GetMapping(value= "/models", params = "type=fridge")
    public ResponseEntity<List<FridgeDTO>> getFridges(
            FridgeParams fridgeParams
    )
    {
        Specification<Fridge> spec = fridgeSpecification.build(fridgeParams);
        return ResponseEntity.ok(fridgeService.getAllFridges(spec));
    }

    @PostMapping("/model/create/fridge")
    public ResponseEntity<FridgeDTO> createComputer(@Valid @RequestBody FridgeRequestDTO request) {

        FridgeCompressorType compressorType = fridgeCompressorTypeService.getByName(request.getCompressor());

        if (compressorType == null)
            compressorType = fridgeCompressorTypeService.create(new FridgeCompressorType(null, request.getCompressor()));

        Model model = createCurrentModelService.createModel(request);

        Fridge fridge = new Fridge(null, request.getNumberOfDoors(), compressorType, model);

        return new ResponseEntity<>(fridgeService.create(fridge).createDTO(), HttpStatus.CREATED);
    }

}
