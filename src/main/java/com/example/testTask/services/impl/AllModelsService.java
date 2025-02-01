package com.example.testTask.services.impl;

import com.example.testTask.models.AllModels;
import com.example.testTask.repositories.AllModelsRepository;
import com.example.testTask.services.AllModelsServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllModelsService implements AllModelsServiceInterface {

        @Autowired
        AllModelsRepository repository;

        @Override
        public List<AllModels> getAllModels(Specification<AllModels> spec)
        {
            return repository.findAll(spec);
        }
}
