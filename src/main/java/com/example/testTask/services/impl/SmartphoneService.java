package com.example.testTask.services.impl;

import com.example.testTask.models.Fridge;
import com.example.testTask.models.Smartphone;
import com.example.testTask.repositories.SmartphoneRepository;
import com.example.testTask.services.SmartphoneServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneService implements SmartphoneServiceInterface {

    @Autowired
    private SmartphoneRepository repository;

    @Override
    public List<Smartphone> getAllSmartphones(Specification<Smartphone> spec)
    {
        return repository.findAll(spec);
    }
}
