package com.example.testTask.services;

import com.example.testTask.models.Fridge;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface FridgeServiceInterface {

    public List<Fridge> getAllFridges(Specification<Fridge> spec);
    public Fridge create(Fridge fridge);
}
