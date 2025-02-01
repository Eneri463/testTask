package com.example.testTask.services;

import com.example.testTask.models.AllModels;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface AllModelsServiceInterface {

    public List<AllModels> getAllModels(Specification<AllModels> spec);

}
