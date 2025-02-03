package com.example.testTask.services.impl;

import com.example.testTask.models.Fridge;
import com.example.testTask.repositories.FridgeRepository;
import com.example.testTask.services.FridgeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FridgeService implements FridgeServiceInterface {

    @Autowired
    FridgeRepository repository;

    @Override
    public List<Fridge> getAllFridges(Specification<Fridge> spec)
    {
        return repository.findAll(spec);
    }

}
