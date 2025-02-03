package com.example.testTask.services.impl;

import com.example.testTask.models.Model;
import com.example.testTask.repositories.ModelRepository;
import com.example.testTask.services.ModelServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService implements ModelServiceInterface {

        @Autowired
        private ModelRepository repository;

        @Override
        public List<Model> getAllModels(Specification<Model> spec)
        {
            return repository.findAll(spec);
        }
}
