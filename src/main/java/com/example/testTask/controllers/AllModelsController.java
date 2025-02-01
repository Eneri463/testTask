package com.example.testTask.controllers;

import com.example.testTask.dto.PostParamsDTO;
import com.example.testTask.models.AllModels;
import com.example.testTask.services.AllModelsServiceInterface;
import com.example.testTask.specifications.GeneralSpecification;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@AllArgsConstructor
public class AllModelsController {

    @Autowired
    AllModelsServiceInterface allModelsService;

    @GetMapping("/all")
    public List<AllModels> getAllAppliances(PostParamsDTO postParamsDTO)
    {
        Specification<AllModels> spec = GeneralSpecification.filter(postParamsDTO);

        return allModelsService.getAllModels(spec);
    }

}
